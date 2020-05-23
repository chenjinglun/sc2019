package com.xzsd.app.order.entity;

public class OrderEntity {
    /**
     * 订单编号
     */
    private String orderNo;
    /*
     * 订单详情列表编号
     */
    private String orderCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品购买的数量
     */
    private int goodsNum;
    /**
     * 商品价格
     */
    private double goodsPrice;
    /**
     * 商品图片地址
     */
    private String goodsImage;
    /***
     * 创建用户
     */
    private String createUser;
    /**
     * 支付状态
     */
    private String payState;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}
