package com.xzsd.app.order.entity;

import java.util.List;

public class OrderListEntity {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *订单状态
     */
    private int orderState;
    /**
     *商品列表详情
     */
    private List<OrderListUnitEntity> orderGoodList;
    /**
     * 总价
     */
    private double payMoney;

    /**
     *创建时间
     */
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

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

    public List<OrderListUnitEntity> getOrderGoodList() {
        return orderGoodList;
    }

    public void setOrderGoodList(List<OrderListUnitEntity> orderGoodList) {
        this.orderGoodList = orderGoodList;
    }
}
