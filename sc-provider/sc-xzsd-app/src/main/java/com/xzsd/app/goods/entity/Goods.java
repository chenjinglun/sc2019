package com.xzsd.app.goods.entity;

/**
 * 二级分类列表以及商品查询
 * @return Response
 * @author scout
 * @Date 2020年4月21日
 */
public class Goods {
    /**
     * 分类编号
     */
    private String cateCode;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 父级分类标记 0：一级分类 / 二级分类为对应一级分类编号
     */
    private String cateParent;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片
     */
    private String imageCode;
    /**
     * 商品价格
     */
    private float sellingPrice;

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateParent() {
        return cateParent;
    }

    public void setCateParent(String cateParent) {
        this.cateParent = cateParent;
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

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
