package com.xzsd.app.userInformation.entity;

public class UserEntity {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户角色
     */
    private int userRole;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
