package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.TopVo;
import com.xzsd.pc.user.entity.UserInfo ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Author scout
 * @Date 2020-03-25
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userCode,userAcct
     * @return
     */
    int countUserAcct(@Param("userAcct") String userAcct,@Param("userCode")String userCode);
    /**
     * 统计用户ID
     * @param userCode
     * @return
     */
    int countUsercode(String userCode);
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);
    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo>listUsersByPage(UserInfo userInfo);
    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode,@Param("userId") String userId);
    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);
    int updateUser2(UserInfo userInfo);
    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    UserInfo getUserByUserCode(@Param("userCode") String userCode);
    /**
     * 添加客户接口
     * @param userCode
     * @return
     */
    int addCustomer(@Param("userCode")String userCode);
    /**
     * 查询顶部栏信息接口
     * @param userId
     * @return
     */
    TopVo getTopOfColumn(@Param("userId")String userId);
}

