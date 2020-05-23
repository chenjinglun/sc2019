package com.xzsd.app.shoppingCart.dao;


import com.xzsd.app.shoppingCart.entity.AddShoppingcartEntity;
import com.xzsd.app.shoppingCart.entity.CartGoodsListEntity;
import com.xzsd.app.shoppingCart.entity.listforEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartDao {
    /**
     * 增加商品购物车商品
     * @param addShoppingcart
     * @return
     */
    int addShoppingCart(AddShoppingcartEntity addShoppingcart);
    /**
     * 判断库存是否充足
     * @param goodsCode
     * @return
     */
    int stock(@Param("goodsCode") String goodsCode);
    /**
     * 检测商品是否已经在购物车
     * @param addShoppingcart
     * @return
     */
    String exitCart(AddShoppingcartEntity addShoppingcart);
    /**
     * 新增购物车时更新商品数量
     * @param addShoppingcart
     * @return
     */
    int updateCartNum(AddShoppingcartEntity addShoppingcart);
    /**
     * 删除购物车对应编号的商品
     * @param addShoppingcart
     * @return
     */
    int deleteCartGood(AddShoppingcartEntity addShoppingcart);
    /**
     * 从购物车表中查找该商品编号
     * @param addShoppingcart
     * @return
     */
    String queryGoodsCode(AddShoppingcartEntity addShoppingcart);
    /**
     * 修改购物车商品数量
     * @param addShoppingcart
     * @return
     */
    int updateCartGood(AddShoppingcartEntity addShoppingcart);
    /**
     * 批量删除购物车商品
     * @param cartCodeList
     * @return
     */
    int deleteCartGoodlist(@Param("cartCodeList") List<String> cartCodeList);
    /**
     * 购物车列表查询
     * @param listforEntity
     * @return
     */
    List<CartGoodsListEntity>listShoppingCarts(listforEntity listforEntity);
}
