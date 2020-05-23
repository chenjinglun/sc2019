package com.xzsd.app.updateInvitation.entity;

public class UpdateEntity {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 邀请码
     */
    private String invitation;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }
}
