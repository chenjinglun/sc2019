package com.xzsd.app.order.entity;

public class OrderListUnitEntity {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     *商品售价
     */
    private String goodsSale;
    /**
     *商品数量
     */
    private String goodsNum;
    /**
     * 商品图片
     */
    private String imageUrl;
    /**
     * 商品介绍
     *
     */
    private String goodsDetail;

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
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

    public String getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(String goodsSale) {
        this.goodsSale = goodsSale;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
