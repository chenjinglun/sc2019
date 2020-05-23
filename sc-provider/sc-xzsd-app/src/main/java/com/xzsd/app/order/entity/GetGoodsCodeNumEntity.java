package com.xzsd.app.order.entity;

public class GetGoodsCodeNumEntity {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     *商品数量
     */
    private int goodsNum;

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
}
