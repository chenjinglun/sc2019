package com.xzsd.app.StorerOrder.entity;

public class OrderDetailGoodsListEntity {
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
    private String goodsSale;
    /**
     *商品描述
     */
    private String goodsPrec;
    /**
     *商品数量
     */
    private String goodsNum;
    /**
     * 商品图片地址
     */
    private String goodsImage;

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

    public String getGoodsPrec() {
        return goodsPrec;
    }

    public void setGoodsPrec(String goodsPrec) {
        this.goodsPrec = goodsPrec;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }
}
