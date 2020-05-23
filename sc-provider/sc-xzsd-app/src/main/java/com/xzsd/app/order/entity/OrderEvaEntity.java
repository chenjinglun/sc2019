package com.xzsd.app.order.entity;

import java.util.List;

public class OrderEvaEntity {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 当前用户编号
     */
    private String userCode;
    /**
     * 评价集合
     */
    private List<OrderEvaUnitEntity> evaList;

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

    public List<OrderEvaUnitEntity> getEvaList() {
        return evaList;
    }

    public void setEvaList(List<OrderEvaUnitEntity> evaList) {
        this.evaList = evaList;
    }
}
