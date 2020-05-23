package com.xzsd.app.updateInvitation.dao;

import com.xzsd.app.updateInvitation.entity.UpdateEntity;

public interface UpdateDao {
    /**
     * 修改邀请码
     * @param updateEntity
     * @return
     */
    int updateCode(UpdateEntity updateEntity);
    /**
     * 查询门店邀请码是否存在
     * @param updateEntity
     * @return
     */
    int ExistInvest(UpdateEntity updateEntity);

}
