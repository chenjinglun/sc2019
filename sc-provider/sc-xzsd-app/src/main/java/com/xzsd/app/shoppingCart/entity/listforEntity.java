package com.xzsd.app.shoppingCart.entity;

public class listforEntity {
    /**
     *页数量
     */
    private int pageSize;
    /**
     *页号
     */
    private int pageNum;
    /**
     * 用户编号
     */
    private String userCode;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
