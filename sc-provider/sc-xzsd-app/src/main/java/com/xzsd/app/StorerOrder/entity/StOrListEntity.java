package com.xzsd.app.StorerOrder.entity;

import java.util.List;

public class StOrListEntity {
    /**
     *订单编号
     */
    private String orderCode;
    /**
     *订单状态
     */
    private int orderState;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userPhone;
    /**
     * 订单详情列表
     */
    private List<StOrListAllEntity> orderGoodList;

    /**
     *总价
     */
    private double payMoney;

    public double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(double payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
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

    public List<StOrListAllEntity> getOrderGoodList() {
        return orderGoodList;
    }

    public void setOrderGoodList(List<StOrListAllEntity> orderGoodList) {
        this.orderGoodList = orderGoodList;
    }
}
