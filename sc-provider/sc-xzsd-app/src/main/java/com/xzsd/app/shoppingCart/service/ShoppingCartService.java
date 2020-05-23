package com.xzsd.app.shoppingCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingCart.entity.AddShoppingcartEntity;
import com.xzsd.app.shoppingCart.entity.CartGoodsListEntity;
import com.xzsd.app.shoppingCart.entity.listforEntity;
import com.xzsd.app.util.ResponceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static com.xzsd.app.util.AuthUtils.generateMixString;

/**
 * @author scout
 * @Deprecated 购物车
 * @time 2020年4月22日
 */
@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;
    /**
     * 新增购物车
     * @param addShoppingCart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addShoppingCart(AddShoppingcartEntity addShoppingCart) {
        //判断传入参数
        if (null == addShoppingCart.getGoodsCode() || addShoppingCart.getGoodsCode() == "") {
            return  ResponceData.bizError("商品编号参数为空!");
        }
        //商品的数量参数不能为0
        if (addShoppingCart.getCnt() == 0) {
            return ResponceData.bizError("商品数量参数不能为0并且不能为空!");
        }
        addShoppingCart.setUserCode(SecurityUtils.getCurrentUserId());
        System.out.println("userCode= "+SecurityUtils.getCurrentUserId());
        //判断商品库存量
        int count = shoppingCartDao.stock(addShoppingCart.getGoodsCode());
        if (count < addShoppingCart.getCnt()) {
            return ResponceData.bizError("商品库存不足!");
        }

        //判断其购物车是否已经有此类商品，有更新商品数量，不新增购物车
        String cartCode = shoppingCartDao.exitCart(addShoppingCart);
        if (null != cartCode && cartCode.length() > 0) {
            //商品已经存在，更新商品数量就行了
            int result = shoppingCartDao.updateCartNum(addShoppingCart);
            if (result > 0) {
                return ResponceData.success("更新购物车商品数量成功!");
            }
            return ResponceData.bizError("更新购物车商品数量失败!");
        }
        //随机生成编号
        addShoppingCart.setCartCode(generateMixString(4));
        //增加
        int result = shoppingCartDao.addShoppingCart(addShoppingCart);
        //结果
        if (result > 0) {
            return ResponceData.success("新增成功！");
        }
        return ResponceData.bizError("新增失败，请重试");
    }

    /**
     * 购物车修改
     * @param addShoppingCart
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateShoppingCart(AddShoppingcartEntity addShoppingCart) {
        //先判断参数是否齐全
        addShoppingCart.setUserCode(SecurityUtils.getCurrentUserId());
        if (null == addShoppingCart.getCartCode() || addShoppingCart.getCartCode() == "") {
            return ResponceData.bizError("购物车编号参数为空!");
        }
        if (null == addShoppingCart.getUserCode() || addShoppingCart.getUserCode() == "") {
            return ResponceData.bizError("用户编号参数为空!");
        }
        //购物车商品数量为0.直接删除购物车对应的购物车编号
        if (addShoppingCart.getCnt() == 0) {
            int result = shoppingCartDao.deleteCartGood(addShoppingCart);
            if (result > 0) {
                return ResponceData.success( "删除购物车对应商品成功!");
            }
            return ResponceData.bizError("删除购物车对应商品失败!");
        }
        //判断 该商品的库存数量 是否 大于 待修改的商品数量
        int count = shoppingCartDao.stock(shoppingCartDao.queryGoodsCode(addShoppingCart));
        if (count < addShoppingCart.getCnt()) {
            return ResponceData.bizError("该商品库存不足!");
        }
        //修改购物车此种商品数量
        int result = shoppingCartDao.updateCartGood(addShoppingCart);
        //结果
        if (result > 0) {
            return  ResponceData.success( "修改购物车商品数量成功!");
        }
        return ResponceData.bizError("修改购物车商品数量失败!");
    }
    /**
     * 购物车商品删除
     * @param cartCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteShoppingCart(String cartCode){
        List<String> cartCodeList = Arrays.asList(cartCode.split(","));
        int result = shoppingCartDao.deleteCartGoodlist(cartCodeList);
        if(result > 0){
            return ResponceData.success( "删除成功!");
        }
        return ResponceData.bizError("删除失败!");
    }
    /**
     * 购物车列表查询
     * @param listforEntity
     * @return
     */
    public ResponceData listShoppingCarts(listforEntity listforEntity){
        listforEntity.setUserCode(SecurityUtils.getCurrentUserId());
        //判断参数是否齐全
        if (null == listforEntity.getUserCode() || listforEntity.getUserCode() == "") {
            return ResponceData.bizError("用户编号参数缺失!");
        }
        //查询列表
        PageHelper.startPage(listforEntity.getPageNum(),listforEntity.getPageSize());
        List<CartGoodsListEntity>cartGoodLists = shoppingCartDao.listShoppingCarts(listforEntity);
        PageInfo<CartGoodsListEntity>cartGoodListPageInfo = new PageInfo<>(cartGoodLists);
        //结果
        if(cartGoodLists.size() > 0){
            return ResponceData.success( "查询成功!", cartGoodListPageInfo);
        }
        return ResponceData.bizError("获取为空!");
    }

}
