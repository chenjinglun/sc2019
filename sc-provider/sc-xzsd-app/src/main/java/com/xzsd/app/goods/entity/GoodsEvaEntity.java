package com.xzsd.app.goods.entity;


/**
 * 参数实体类
 */
public class GoodsEvaEntity {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     *商品评价等级
     */
    private int startLevel;
    /**
     * 页号
     */
    private int pageNum;
    /**
     * 页数量
     */
    private int pageSize;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
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
