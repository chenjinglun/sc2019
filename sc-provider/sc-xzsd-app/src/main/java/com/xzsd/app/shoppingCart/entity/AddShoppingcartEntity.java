package com.xzsd.app.shoppingCart.entity;

public class AddShoppingcartEntity {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品数量
     */
    private int cnt;

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
