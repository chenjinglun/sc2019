package com.xzsd.app.shoppingCart.controller;


import com.xzsd.app.shoppingCart.entity.AddShoppingcartEntity;
import com.xzsd.app.shoppingCart.entity.listforEntity;
import com.xzsd.app.shoppingCart.service.ShoppingCartService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * @author scout
 * @Deprecated 购物车
 * @time 2020年4月22日
 */
@RestController
@RequestMapping("clientShopCart")
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
    @Resource
    private ShoppingCartService cartService;
    @ResponseBody
        /**
         * 增加购物车商品
         */
    @PostMapping("addShoppingCart")
    public ResponceData addShoppingCart(AddShoppingcartEntity addShoppingCart) {
        try {
            return cartService.addShoppingCart(addShoppingCart);
        } catch (Exception e){
        logger.error("增加购物车商品失败",e);
        System.out.println(e.toString());
        throw  e;
    }
    }
    /**
     * 修改购物车
     * @param addShoppingCart
     * @return
     */
    @PostMapping("updateShoppingCart")
    public ResponceData updateShoppingCart(AddShoppingcartEntity addShoppingCart) {
        try {
            return cartService.updateShoppingCart(addShoppingCart);
        } catch (Exception e){
            logger.error("修改购物车失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 删除购物车数量
     * @param cartCode
     * @return
     */
    @PostMapping("deleteShoppingCartGoods")
    public ResponceData deleteShoppingCart(String cartCode) {
        try {
            return cartService.deleteShoppingCart(cartCode);
        } catch (Exception e){
            logger.error("修改购物车数量失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 购物车列表查询
     * @param listforEntity
     * @return
     */
    @PostMapping("listShoppingCarts")
    public ResponceData listShoppingCarts(listforEntity listforEntity) {
        try {
            return cartService.listShoppingCarts(listforEntity);
        } catch (Exception e){
            logger.error("购物车列表查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
