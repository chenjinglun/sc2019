package com.xzsd.app.order.entity;

public class BuyNowEntity {
    private String goodsCode;
    /**
     * 商品数量
     */
    private int goodsNum;
    /**
     * 门店编号，也就是取货门店
     */
    private String shopCode;
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *用户编号
     */
    private String userCode;
    /**
     *订单价格
     */
    private double orderPrice;
    /**
     * 订单描述
     */
    private String orderPre;

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

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
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

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderPre() {
        return orderPre;
    }

    public void setOrderPre(String orderPre) {
        this.orderPre = orderPre;
    }
}
