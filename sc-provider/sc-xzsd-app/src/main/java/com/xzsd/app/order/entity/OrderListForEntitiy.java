package com.xzsd.app.order.entity;

public class OrderListForEntitiy {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     *订单名字
     */
    private String orderName;
    /**
     *订单状态
     */
    private int orderState;
    /**
     *页号
     */
    private int pageNum;
    /**
     *页数量
     */
    private int pageSize;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
