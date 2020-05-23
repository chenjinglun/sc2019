package com.xzsd.app.shoppingCart.entity;

public class CartGoodsListEntity {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     *商品编号
     */
    private String goodsCode;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品数量
     */
    private int cnt;
    /**
     *商品售价
     */
    private double sellingPrice;
    /**
     *商品图片地址
     */
    private String ImageUrl;

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
