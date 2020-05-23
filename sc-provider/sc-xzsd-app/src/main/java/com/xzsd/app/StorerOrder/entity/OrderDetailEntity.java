package com.xzsd.app.StorerOrder.entity;

import java.util.List;

public class OrderDetailEntity {
    /**
     *订单编号
     */
    private String orderCode;
    /**
     * 详细
     */
    private String Address;
    /**
     *订单取货门店名称
     */
    private String deliveryStore;
    /**
     *订单创建时间
     */
    private String orderCreateTime;
    /**
     *订单状态
     */
    private String orderState;
    /**
     *用户名字
     */
    private String userName;
    /**
     *用户手机号
     */
    private String userPhone;
    /**
     *订单商品列表详情x
     */
    private List<OrderDetailGoodsListEntity> orderGoodsList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<OrderDetailGoodsListEntity> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderDetailGoodsListEntity> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }
}
