package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.AppUserInfo;

import com.xzsd.app.userInformation.entity.PasswordEntity;
import com.xzsd.app.userInformation.entity.UserEntity;
import com.xzsd.app.userInformation.entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserInformationDao {

    int getUserRole(@Param("userCode") String userCode);
    String getInvitation(@Param("userCode") String userCode);
    AppUserInfo getUserIsCustomer(@Param("userCode") String userCode);
    AppUserInfo getUserIsCustomer2(@Param("userCode") String userCode);
    AppUserInfo getUserIsStore(@Param("userCode") String userCode);
    AppUserInfo getUserIsAdmin(@Param("userCode") String userCode);
    AppUserInfo getUserIsDriver(@Param("userCode") String userCode);
    String getPassword(@Param("userCode") String userCode);
    int updateUserPassword(@Param("userCode") String userCode,@Param("userNewPassword") String userNewPassword);
    /**
     * 查询原来的密码
     * @param passwordEntity
     * @return
     */
    PasswordEntity getOrignPass(PasswordEntity passwordEntity);
    /**
     * 更新密码
     * @param passwordEntity
     * @return
     */
    int updatePassWord(PasswordEntity passwordEntity);
    /**
     * 查询当前用户的角色
     * @return
     */
    UserEntity queryCurrUser(@Param("userCode")String userCode);
}
