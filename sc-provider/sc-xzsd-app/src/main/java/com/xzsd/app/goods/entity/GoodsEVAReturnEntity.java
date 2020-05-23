package com.xzsd.app.goods.entity;

/**
 * 商品评价实体类
 */
public class GoodsEVAReturnEntity {
    /**
     *评价编号
     */
    private String userCode;
    /**
     *评价星级
     */
    private int startLevel;
    /**
     *评价用户名称
     */
    private String userAcct;
    /**
     *评价者评论
     */
    private String Content;
    /**
     *评价时间
     */
    private String evaTime;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(String evaTime) {
        this.evaTime = evaTime;
    }
    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }
}
