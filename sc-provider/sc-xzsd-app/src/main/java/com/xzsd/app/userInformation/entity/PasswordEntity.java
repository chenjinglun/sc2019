package com.xzsd.app.userInformation.entity;

public class PasswordEntity {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户输入的原密码
     */
    private String userPass;
    /**
     * 输入的密码
     */
    private String cinPass;
    /**
     * 用户密码
     */
    private String userNewPass;
    /**
     * 司机密码
     */
    private String driverPass;
    /**
     * 用户角色
     */
    private int Role;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getCinPass() {
        return cinPass;
    }

    public void setCinPass(String cinPass) {
        this.cinPass = cinPass;
    }

    public String getUserNewPass() {
        return userNewPass;
    }

    public void setUserNewPass(String userNewPass) {
        this.userNewPass = userNewPass;
    }

    public String getDriverPass() {
        return driverPass;
    }

    public void setDriverPass(String driverPass) {
        this.driverPass = driverPass;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }
}
