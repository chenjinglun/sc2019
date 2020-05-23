package com.xzsd.app.order.entity;

public class OrderDetailGoodsListEntitiy {
    /**
     *商品编号
     */
    private String  goodsCode;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品售价
     */
    private String goodsSale;
    /**
     *商品介绍
     */
    private String goodsdetail;
    /**
     *商品数量
     */
    private int goodsNum;
    /**
     * 商品图片地址
     */
    private String goodsImageUrl;

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

    public String getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(String goodsSale) {
        this.goodsSale = goodsSale;
    }

    public String getGoodsdetail() {
        return goodsdetail;
    }

    public void setGoodsdetail(String goodsdetail) {
        this.goodsdetail = goodsdetail;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }
}
