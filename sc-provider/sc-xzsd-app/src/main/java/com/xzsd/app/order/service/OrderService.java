package com.xzsd.app.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.entity.*;
import com.alibaba.fastjson.JSONObject;
import com.xzsd.app.util.ResponceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xzsd.app.util.AuthUtils.generateMixString;
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    /**
     *  订单新增
     * @param addOrderEntity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addOrder(addOrderEntity addOrderEntity){
        //判断参数是否缺失
        if(null == addOrderEntity.getCartCode() || addOrderEntity.getCartCode() == ""){
            return ResponceData.bizError("购物车编号为空");
        }
        //获取当前登入人的编号
        addOrderEntity.setUserCode(SecurityUtils.getCurrentUserId());
        String count = orderDao.panduan(SecurityUtils.getCurrentUserId());
        if(count == null ){
            return ResponceData.bizError("您未绑定所属门店，请前往绑定门店！");
        }
        System.out.println(addOrderEntity.getUserCode());
        //将多个购物车编号写成字符串
        List<String> cartCodeList = Arrays.asList(addOrderEntity.getCartCode().split(","));
        String msg = "";
        //生成随机订单编号
        addOrderEntity.setOrderCode(generateMixString(4));
        //初始化订单号
        int result = orderDao.addOrder(addOrderEntity);
        System.out.println("----------------"+result);
        if(result > 0) {
            msg = "初始化订单成功!";
            List<String> newCartCodeList = new ArrayList<>();
            //查询购物车中 有没有商品已经下架或者已删除, 返回已经下架的 购物车编号 已下架的商品无法购买
            List<cartCodelistEntity> goodsOnShelves = orderDao.goodsExpired(cartCodeList);
            if (goodsOnShelves.size() > 0) {
                //将CartCodeList去除已过期的商品
                msg = msg + "清除已下架的商品" + goodsOnShelves.size() + "个!";
            }
            boolean con;
            //将已经下架的商品 从 购物车中清除
            for (int i = 0; i < cartCodeList.size(); i++) {
                con = true;
                for (int j = 0; j < goodsOnShelves.size(); j++) {
                    if (goodsOnShelves.get(j).getCartCode().equals(cartCodeList.get(i))) {
                        con = false;
                    }
                }
                if (con == true) {
                    //说明是不过期的商品，则保留
                    newCartCodeList.add(cartCodeList.get(i));
                }
            }
            //此时list中留下来的是没有过期的商品的购物车编号
            //根据 购物车编号 查询待新增的 订单商品列表
            if(newCartCodeList.size() > 0){
                //判断购物车中每种商品的数量库存 是否大于等于购物车中的每种商品数量返回那些不符合数量的商品编号
                List<GoodstockEnitiy> nonConformingProducts = orderDao.judgementStock(newCartCodeList);
                if(nonConformingProducts.size() > 0){
                    //将那些购物车的数量修改为当前商品库存的库存的最大数量，如果商品数量库存当前为0，购物车对应商品数量也要替换成 0。
                    String updateCodeList = "";
                    int index = 0;
                    String str = ",";
                    //用逗号拼接上面经过过滤的 带插入到订单商品详情的购物车编号
                    for(GoodstockEnitiy goodstock:nonConformingProducts){
                        if(index == 0){
                            str = "";
                        }
                        updateCodeList = updateCodeList+goodstock.getGoodsCode()+str;
                    }
                    //去将购物车每件商品进行判断和更新，如果 某一件类型的商品数量大于商品库存，则  更新商品库存最大值
                    int updateNum = orderDao.updateGoodNum(Arrays.asList(updateCodeList.split(",")));
                    if(updateNum > 0){
                        msg = msg + "已更新部分购物车商品数量!";
                    }
                }
                //生成订单后， 需要10分钟之内进行支付，否则 订单删除，商品库存恢复，
                // 如果支付成功[订单 这里默认支付成功]，那么将纪录添加到顾客表，并且将 订单商品详情增加到对应表
                List<OrderEntity> orderList = orderDao.queryOrderList(newCartCodeList);
                orderPriceEntity updateOrderPrice = new orderPriceEntity();
                double allPrice = 0;
                for(int i = 0;i < orderList.size();i++){
                    //给每个订单商品详情随机生成订单详情编号
                    orderList.get(i).setOrderCode(generateMixString(4));
                    orderList.get(i).setOrderNo(addOrderEntity.getOrderCode());
                    allPrice += orderList.get(i).getGoodsNum()*orderList.get(i).getGoodsPrice();
                }
                //如果 购物车内待购买的商品种类 数量大于0， 那么 将购买的商品种类信息新增到订单详情
                if(orderList.size() > 0){
                    // 还要将对应的商品库存数量减少
                    orderDao.updateGoodRelative(orderList);
                    //新增到订单详情表  [这里漏了需要存商品的图片，需要补上
                    result = orderDao.addOrderList(orderList);
                    //更新订单总价格  而且需要存 门店编号
                    updateOrderPrice.setPrice(allPrice);
                    updateOrderPrice.setUpdateUser(SecurityUtils.getCurrentUserUsername());
                    updateOrderPrice.setOrderCode(addOrderEntity.getOrderCode());
                    int updateCount = orderDao.updateOrderCount(updateOrderPrice);
                    //判断新增到 订单详情列表的 结果
                    if(result > 0){
                        //下单成功后，需要清空对应的购物车
                        int empty = orderDao.clearEmpty(cartCodeList);
                        if(empty > 0){
                            msg = msg + "已清空购物车!下单成功!";
                        }
                        return ResponceData.success(msg);
                    }
                }
            }
            //更新订单 删除
            result = orderDao.deleteOrder(addOrderEntity.getOrderCode(),SecurityUtils.getCurrentUserUsername());
            return ResponceData.bizError(msg+"新增订单失败,您购物车内的商品均被抢空或已下架!");
        }
        //判断结果
        return ResponceData.bizError("新增订单失败");
    }

    /**
     * 查询订单详情
     * @return
     */
    public ResponceData queryOrderDetail(OrderDetailEntity orderDetail){
        //判断订单编号参数
        if(null == orderDetail.getOrderCode() || orderDetail.getOrderCode() == ""){
            return ResponceData.bizError("订单编号为空!");
        }
        OrderDetailEntity orderDetailOut = orderDao.queryOrderDetail(orderDetail.getOrderCode());
        List <OrderDetailGoodsListEntitiy> goodsList =  orderDao.querygoodslist(orderDetail.getOrderCode());
        orderDetailOut.setOrderGoodsList(goodsList);
        //判断结果
        if(null != orderDetailOut.getOrderCode()){
            //输出实体类
            return ResponceData.success("查询订单成功!",orderDetailOut);
        }
        return ResponceData.bizError("查询订单为空");
    }
    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    public  ResponceData updateOrder(UpdateOrderEntitiy updateOrder){
        if(null == updateOrder.getOrderCode()){
            return ResponceData.bizError("订单编号为空!");
        }
        if(updateOrder.getOrderState() == 0){
            return ResponceData.bizError("订单状态不能为0!");
        }
        //如果是取消订单状态，那么需要库存加回对应订单编号所对应 商品的数量
        //先获取在订单详情列表的 商品编号和数量
        if(updateOrder.getOrderState() == 6) {
            List<GetGoodsCodeNumEntity> getOrderGoodCodeAndNumList = orderDao.queryOrderGoodCode(updateOrder.getOrderCode());
            //然后去更新
            int updateNum = orderDao.updateGoodLibSaveAndSaleNum(getOrderGoodCodeAndNumList);
            //然后将 订单商品详情列表数据 删除
            if (updateNum > 0){
                return ResponceData.success("取消订单成功!");
        }
        return ResponceData.bizError("取消订单失败，请重试!");
        }
        //获取当前修改人的Id
        updateOrder.setUpdateUser(SecurityUtils.getCurrentUserId());
        //修改
        int result = orderDao.updateOrder(updateOrder);
        if(result > 0){
            return ResponceData.success("更新状态成功!");
        }
        return ResponceData.bizError("修改状态失败!");
    }
    /**
     * 查询订单列表
     * @param orderListForEntitiy
     * @return
     */
    public ResponceData queryUserOrderList(OrderListForEntitiy orderListForEntitiy){
//        //查询当前登入人的编号
        String userID = SecurityUtils.getCurrentUserId();
        //设置当前登入用户编号
        orderListForEntitiy.setUserCode(userID);
        //查询
        PageHelper.startPage(orderListForEntitiy.getPageNum(),orderListForEntitiy.getPageSize());
        List list = new ArrayList();
        List<OrderListEntity>orderLists = orderDao.queryUserOrderList(orderListForEntitiy);
        for (int i = 0;i<orderLists.size(); i++){
            OrderListEntity list2 = new OrderListEntity();
            List<OrderListUnitEntity> goodslist = orderDao.querygoods(orderLists.get(i).getOrderCode());
            list2.setOrderGoodList(goodslist);
            list2.setOrderCode(orderLists.get(i).getOrderCode());
            list2.setOrderState(orderLists.get(i).getOrderState());
            list2.setPayMoney(orderLists.get(i).getPayMoney());
            list.add(list2);
        }
        PageInfo<OrderListEntity>listss = new PageInfo<>(list);
        //判断结果
        if(orderLists.size() > 0){
            return ResponceData.success("查询成功!",listss);
        }
        return ResponceData.bizError("查询为空!");
    }
    /**
     * 增加订单商品评价
     * @param orderEvaEntity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addOrderGoodsEva(OrderEvaEntity orderEvaEntity){
        //开始处理对象
        if(null == orderEvaEntity.getOrderCode()){
            return ResponceData.bizError("订单编号缺失!");
        }
        //为 每件商品评价 生成编号
        orderEvaEntity.setUserCode(SecurityUtils.getCurrentUserId());
        for(int i = 0;i < orderEvaEntity.getEvaList().size();i++){
            orderEvaEntity.getEvaList().get(i).setCommentCode(generateMixString(4));
            orderEvaEntity.getEvaList().get(i).setCreateUser(orderEvaEntity.getUserCode());
        }
        //当前用户-新增至商品评价列表
        int result = orderDao.addOrderGoodsEva(orderEvaEntity.getEvaList(),orderEvaEntity.getOrderCode());
        //更新订单状态为 已评价
        UpdateOrderEntitiy updateOrder = new UpdateOrderEntitiy();
        updateOrder.setOrderCode(orderEvaEntity.getOrderCode());
        updateOrder.setOrderState(6);
        updateOrder.setUpdateUser(SecurityUtils.getCurrentUserUsername());
        int updateOrderState = orderDao.updateOrder(updateOrder);
        //更新商品星级
        int updateOrdeerRank = orderDao.updateGoodRank(orderEvaEntity.getEvaList());
        //结果
        if(result > 0){
            return ResponceData.success("添加商品评论成功!",result);
        }
        //判断结果
        return ResponceData.bizError("添加商品评论失败!");
    }
    /**
     * 立即购买 新增订单 接口
     * @param buyNowEntity
     * @return
     */
    public ResponceData BuyGoods(BuyNowEntity buyNowEntity){
        //判断参数
        if(null == buyNowEntity.getGoodsCode() ||buyNowEntity.getGoodsCode() == ""){
            return ResponceData.bizError("商品编号参数不存在!");
        }
        if(buyNowEntity.getGoodsNum() == 0){
            return ResponceData.bizError("购买的商品数量不能为0!");
        }
        String count = orderDao.panduan(SecurityUtils.getCurrentUserId());
        if(count == null ){
            return ResponceData.bizError("您未绑定所属门店，请前往绑定门店！");
        }
        //判断商品是否 下架 和 售空
        OrderEntity addOrderDetailOut = orderDao.queryIsNullOrExpired(buyNowEntity);
        if(null == addOrderDetailOut){
            return ResponceData.bizError("购买失败!商品库存不足或者已下架!");
        }
        //随机生成订单编号
        buyNowEntity.setOrderCode(generateMixString(4));
        buyNowEntity.setUserCode(SecurityUtils.getCurrentUserId());
        //订单总价格
        addOrderDetailOut.setGoodsNum(buyNowEntity.getGoodsNum());
        buyNowEntity.setOrderPrice(addOrderDetailOut.getGoodsNum()*addOrderDetailOut.getGoodsPrice());
        addOrderDetailOut.setOrderCode(generateMixString(4));
        addOrderDetailOut.setOrderNo(buyNowEntity.getOrderCode());
        addOrderDetailOut.setUserCode(SecurityUtils.getCurrentUserId());
        addOrderDetailOut.setCreateUser(SecurityUtils.getCurrentUserUsername());
        addOrderDetailOut.setPayState("1");
        //获得取货门店门店编号
        //新增到订单  和新增到订单商品详情
        int result = orderDao.addFastBuyOrder(buyNowEntity);
        if(result > 0){
            List<OrderEntity>goods = new ArrayList<>();
            goods.add(addOrderDetailOut);
            int finallyInsert = orderDao.addOrderList(goods);
            if(finallyInsert > 0){
                //增加 销售量和 减少库存
                int finallyUpdate = orderDao.updateGoodRelative(goods);
                if(finallyUpdate > 0){
                    return ResponceData.success("下单成功!");
                }
            }
        }
        //判断商品是售空的了，需要改状态为 售空
        return ResponceData.bizError("购买失败!");
    }
    /**
     *  查询订单评价商品信息列表接口
     * @param orderCode
     */
    public ResponceData listGoodsForEvaluate(String orderCode){
        List<goodsListEntity> goodsList = orderDao.listGoodsForEvaluate(orderCode);
        if (goodsList == null){
            return ResponceData.bizError("查询为空，查询失败");
        }
        return ResponceData.success("查询成功",goodsList);
    }
}
