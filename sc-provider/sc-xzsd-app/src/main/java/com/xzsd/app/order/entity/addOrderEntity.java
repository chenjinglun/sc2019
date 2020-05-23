package com.xzsd.app.order.entity;

public class addOrderEntity {
    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 购物车编号集合
     */
    private String cartCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 门店编号，也就是取货门店
     */
    private String shopCode;

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
