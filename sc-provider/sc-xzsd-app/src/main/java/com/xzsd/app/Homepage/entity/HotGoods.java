package com.xzsd.app.Homepage.entity;

public class HotGoods {
    /**
     *热门商品编号
     */
    private String goodsCode;
    /**
     *热门商品名称
     */
    private String goodsName;
    /**
     *热门商品图片
     */
    private String imageCode;
    /**
     *热门商品价格
     */
    private String sellingPrice;
    /**
     *热门商品位排序
     */
    private String Sort;

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

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }
}
