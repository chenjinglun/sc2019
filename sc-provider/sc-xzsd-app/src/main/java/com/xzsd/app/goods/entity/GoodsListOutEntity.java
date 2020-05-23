package com.xzsd.app.goods.entity;

import java.util.List;

public class GoodsListOutEntity {
    private String classCode;
    private String className;
    private String version;
    private List<GoodClassificationSonEntity> listGoodClassificationSon;
    public String getClassCode() {
        return classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public List<GoodClassificationSonEntity> getListGoodClassificationSon() {
        return listGoodClassificationSon;
    }
    public void setListGoodClassificationSon(List<GoodClassificationSonEntity> listGoodClassificationSon) {
        this.listGoodClassificationSon = listGoodClassificationSon;
    }
}
