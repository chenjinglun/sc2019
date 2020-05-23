package com.xzsd.app.updateInvitation.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.updateInvitation.dao.UpdateDao;
import com.xzsd.app.updateInvitation.entity.UpdateEntity;
import com.xzsd.app.util.ResponceData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 邀请码绑修改
 */
@Service
public class UpdateService {
    @Resource
    private UpdateDao updateDao;
    //查询门店邀请码是否存在
    public ResponceData updateClientInvite(UpdateEntity updateEntity) {
        //参数是否齐全
        if(null == updateEntity.getInvitation() || updateEntity.getInvitation() == ""){
            return ResponceData.bizError("邀请码参数为空");
        }
        //获取当前登入用户编号
        updateEntity.setUserCode(SecurityUtils.getCurrentUserId());
        int result = updateDao.ExistInvest(updateEntity);
        if (result == 0) {
            return ResponceData.bizError("门店邀请码不存在!");
        }
            result = updateDao.updateCode(updateEntity);
            if(result > 0){
                return ResponceData.success("门店邀请码更新成功!");
            }
        return ResponceData.bizError("门店邀请码更新失败!");
    }
    }
