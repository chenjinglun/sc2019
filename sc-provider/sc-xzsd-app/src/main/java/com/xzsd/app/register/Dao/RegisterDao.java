package com.xzsd.app.register.Dao;

import com.xzsd.app.register.entity.RegisterEntity;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

/***
 *
 * @Description :
 * @Author : scout
 * @Date :  2020年4月20日10:06:08
 */
@Mapper
public interface RegisterDao {
    /**
     * 查看用户是否存在
     * @param userAcct 用户信息
     * @return
     */
    int countById(@Param("userAcct") String userAcct);
    /**
     * 注册用户
     * @param registerEntity
     * @return
     */
    int clientRegister(RegisterEntity registerEntity);
    int addCustomer(@Param("userCode")String userCode,@Param("inviteCode") String inviteCode);
}
