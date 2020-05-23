package com.xzsd.app.order.entity;

import java.util.List;

public class OrderDetailEntity {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *取货门店
     */
    private String deliveryStore;
    /**
     *订单创建时间
     */
    private String orderCreateTime;
    /**
     *订单状态
     */
    private int orderState;
    /**
     * 取货详细地址
     */
    private String Address;
    /**
     *订单商品详情列表
     */
    private List<OrderDetailGoodsListEntitiy> orderGoodsList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(String deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<OrderDetailGoodsListEntitiy> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderDetailGoodsListEntitiy> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
//    /*
//     *取货地址
//     */
//    private String provinceCode;
//    private String cityCode;
//    private String distinctCode;
}
