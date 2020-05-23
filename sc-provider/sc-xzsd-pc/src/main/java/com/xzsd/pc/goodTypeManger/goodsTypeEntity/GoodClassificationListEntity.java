package com.xzsd.pc.goodTypeManger.goodsTypeEntity;

import java.util.List;

public class GoodClassificationListEntity {
    /**
     * 分类编号
     */
    private String classCode;
    /**
     * 分类名称
     */
    private String className;
    /**
     * 版本号
     */
    private String version;
    /**
     * 商品分类集合
     */
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
