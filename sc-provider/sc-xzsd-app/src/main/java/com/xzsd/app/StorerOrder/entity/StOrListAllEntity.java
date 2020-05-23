package com.xzsd.app.StorerOrder.entity;
/**
 * 订单列表的商品详情
 */
public class StOrListAllEntity {
    /**
     *商品编号
     */
    private String goodsCode;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品售价
     */
    private double goodsSale;
    /**
     *商品描述
     */
    private String goodPrec;
    /**
     *商品数量
     */
    private int goodsNum;

    /**
     * 商品图片
     */
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public double getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(double goodsSale) {
        this.goodsSale = goodsSale;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodPrec() {
        return goodPrec;
    }

    public void setGoodPrec(String goodPrec) {
        this.goodPrec = goodPrec;
    }
}
