package com.xzsd.app.driver.entity;

public class DriverEntity {
    /**
     * 省编号
     */
    private String provinceCode;
    /**
     *市区编号
     */
    private String cityCode;
    /**
     *区编号
     */
    private String countyCode;


    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
}
