package com.xzsd.app.goods.entity;

import java.util.Date;

public class GoodsDetailEntity {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品售价
     */
    private float sellingPrice;
    /**
     * 商品介绍
     */
    private String skudetail;
    /**
     * 出版社
     */
    private String skuPress;
    /**
     * 作者
     */
    private String AuthorName;
    /**
     * 书号
     */
    private String bookNo;
    /**
     * 图片路径
     */
    private String imageCode;

    /**
     *商店名称
     * @return
     */
    private String storeName;

    /**
     * 评分
     */
    private double orderRank;

    public double getOrderRank() {
        return orderRank;
    }

    public void setOrderRank(double orderRank) {
        this.orderRank = orderRank;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSkudetail() {
        return skudetail;
    }

    public void setSkudetail(String skudetail) {
        this.skudetail = skudetail;
    }

    public String getSkuPress() {
        return skuPress;
    }

    public void setSkuPress(String skuPress) {
        this.skuPress = skuPress;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
