package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    /**
     * 增加订单
     * @param addOrderEntity
     * @return
     */
    int addOrder(addOrderEntity addOrderEntity);
    /**
     * 查询某些商品是否已经下架,返回已下架的商品
     * @param goodsCode
     * @return
     */
    List<cartCodelistEntity>goodsExpired(@Param("list")List<String>goodsCode);
    /**
     * 判断商品库存是否充足
     * @param cartCodeList
     * @return
     */
    List<GoodstockEnitiy>judgementStock(@Param("cartCodeList") List<String> cartCodeList);
    /**
     * 修改商品数量为库存最大，因为购买的商品数量库存比购物车的对应的商品数量要少,如果库存为0，则删除购物车
     * @param cartCodes
     * @return
     */
    int updateGoodNum(@Param("list")List<String>cartCodes);
    /**
     * 准备创建订单，进行查询待购买的商品的信息
     * @param codeLists
     * @return
     */
    List<OrderEntity> queryOrderList(@Param("list")List<String>codeLists);
    /**
     * 更新操作
     * @param orderList
     * @return
     */
    int updateGoodRelative(@Param("list")List<OrderEntity>orderList);
    /**
     * 新增到订单详情  表
     * @param orderList
     * @return
     */
    int addOrderList(@Param("list") List<OrderEntity>orderList);
    /**
     * 清空购物车
     * @param cartCodeList
     * @return
     */
    int clearEmpty(@Param("list") List<String> cartCodeList);
    /**
     * 订单删除
     * @param orderCode
     * @param updateUser
     * @return
     */
    int deleteOrder(@Param("orderCode")String orderCode,@Param("createUser")String updateUser);
    /**
     * 订单编号
     * @param orderCode
     * @return
     */
    OrderDetailEntity queryOrderDetail(@Param("orderCode")String orderCode);
    /**
     * 根据订单编号查询商品
     */
    List<OrderDetailGoodsListEntitiy> querygoodslist (@Param("orderCode")String orderCode);
    /**
     * 根据订单编号找到对饮商品编号和 数量
     * @param code
     * @return
     */
    List<GetGoodsCodeNumEntity>queryOrderGoodCode(@Param("orderCode")String code);

    /**
     * 恢复商品的数量和售出量
     * @param getOrderGoodCodeAndNumList
     * @return
     */
    int updateGoodLibSaveAndSaleNum(@Param("list")List<GetGoodsCodeNumEntity>getOrderGoodCodeAndNumList);
    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    int updateOrder(UpdateOrderEntitiy updateOrder);
    /**
     * 用户订单列表查询
     * @param orderListForEntitiy
     * @return
     */
    List<OrderListEntity>queryUserOrderList(OrderListForEntitiy orderListForEntitiy);
    /**
     * 根据订单编号查询商品
     */
    List<OrderListUnitEntity> querygoods (@Param("orderCode")String orderCode);
    /**
     * 新增商品评价
     * @param orderEvaUnits
     * @param orderCode
     * @return
     */
    int addOrderGoodsEva(@Param("list")List<OrderEvaUnitEntity>orderEvaUnits, @Param("orderCode")String orderCode);
    /**
     * 查看该商品是否已经下架或者卖完
     * @param buyNowEntity
     * @return
     */
    OrderEntity queryIsNullOrExpired (BuyNowEntity buyNowEntity);
    /**
     * 立即购买新增订单
     * @param buyNowEntity
     * @return
     */
    int addFastBuyOrder(BuyNowEntity buyNowEntity);
    /**
     * 更新订单总价格
     * @param orderPriceEntity
     * @return
     */
    int updateOrderCount(orderPriceEntity orderPriceEntity);
    /**
     * 判断是否绑定门店
     */
    String panduan(@Param("userCode") String userCode);
    /**
     *  查询订单评价商品信息列表接口
     * @param orderCode
     */
    List<goodsListEntity>listGoodsForEvaluate(@Param("orderCode") String orderCode);
    /**
     * 更新商品星级
     * @param orderEva
     * @return
     */
    int updateGoodRank(@Param("list")List<OrderEvaUnitEntity> orderEva);
}
