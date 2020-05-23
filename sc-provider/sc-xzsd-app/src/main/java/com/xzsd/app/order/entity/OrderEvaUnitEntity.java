package com.xzsd.app.order.entity;

import java.util.List;

public class
OrderEvaUnitEntity {
    /**
     * 随机生成评价编号
     */
    private String commentCode;
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     *评价等级
     */
    private int  goodRank;
    /**
     *评论
     */
    private String evaContent;
    /**
     *创建者
     */
    private String createUser;
//    /**
//     *图片拼接
//     */
//    private String imageUrlList;
//    /**
//     *每个商品的图片集合
//     */
//    private List<OrderEvaImageEntity> imageList;

    public String getCreateUser() {
        return createUser;
    }

//    public String getImageUrlList() {
//        return imageUrlList;
//    }
//
//    public void setImageUrlList(String imageUrlList) {
//        this.imageUrlList = imageUrlList;
//    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getGoodRank() {
        return goodRank;
    }

    public void setGoodRank(int goodRank) {
        this.goodRank = goodRank;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent;
    }

//    public List<OrderEvaImageEntity> getImageList() {
//        return imageList;
//    }
//
//    public void setImageList(List<OrderEvaImageEntity> imageList) {
//        this.imageList = imageList;
//    }
}
