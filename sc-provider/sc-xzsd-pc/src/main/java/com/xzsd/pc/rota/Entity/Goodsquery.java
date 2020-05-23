package com.xzsd.pc.rota.Entity;

public class Goodsquery {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 商品状态
     */
    private String skuState;
    /**
     * 一级分类名称
     */
    private String onecatename;
    /**
     * 二级分类名称
     */
    private String twocatename;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSkuState() {
        return skuState;
    }

    public void setSkuState(String skuState) {
        this.skuState = skuState;
    }
    public String getTwocatename() {
        return twocatename;
    }

    public void setTwocatename(String twocatename) {
        this.twocatename = twocatename;
    }
    public String getOnecatename() {
        return onecatename;
    }

    public void setOnecatename(String onecatename) {
        this.onecatename = onecatename;
    }
}
