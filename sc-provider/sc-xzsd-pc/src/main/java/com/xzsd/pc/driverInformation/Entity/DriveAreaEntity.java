package com.xzsd.pc.driverInformation.Entity;

public class DriveAreaEntity {
    /**
     * 省编号
     */
    private String provinceNo;
    /**
     *市区编号
     */
    private String cityNo;
    /**
     *区编号
     */
    /**
     * 司机编号
     */
    private String driverNo;
    /**
     * 司机名字
     */
    private String driverName;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String county;

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    private String countyNo;

    public String getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getCityNo() {
        return cityNo;
    }

    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }

    public String getCountyNo() {
        return countyNo;
    }

    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }
}
