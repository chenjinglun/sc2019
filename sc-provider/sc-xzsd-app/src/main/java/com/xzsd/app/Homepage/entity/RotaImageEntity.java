package com.xzsd.app.Homepage.entity;

public class RotaImageEntity {
    /**
     * 轮播图编号
     */
    private String bannerCode;
    /**
     * 轮播图位排序
     */
    private String ins;
    /**
     * 轮播图图片地址
     */
    private String imageUrl;
    /**
     *商品编号
     */
    private String skuNo;

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
