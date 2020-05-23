package com.xzsd.pc.goods.goodsEntity;

public class StoreEntity {
    /**
     * 商店编号
     */
    private String storeNo;
    /**
     * 商店名称
     */
    private String storeName;
    /**
     * 店长编号
     *
     */
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
