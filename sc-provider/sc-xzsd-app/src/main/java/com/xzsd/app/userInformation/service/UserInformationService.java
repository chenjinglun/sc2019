package com.xzsd.app.userInformation.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.userInformation.dao.UserInformationDao;
import com.xzsd.app.userInformation.entity.AppUserInfo;
import com.xzsd.app.userInformation.entity.PasswordEntity;
import com.xzsd.app.userInformation.entity.UserEntity;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.ResponceData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
/**
 * @author scout
 * @date 2020年4月20日10:52:53
 */
@Service
public class UserInformationService {
    @Resource
    private UserInformationDao userDao;
    /**
     * 获取用户信息
     */
    public ResponceData getUser() {
        String userCode = SecurityUtils.getCurrentUserId();
        int role = userDao.getUserRole(userCode);
        String invitation = userDao.getInvitation(userCode);
        AppUserInfo userInfo = new AppUserInfo();
        if (role == 3 && invitation != null) {
            userInfo = userDao.getUserIsCustomer(userCode);
        } else if(role == 3 && invitation == null) {
            userInfo = userDao.getUserIsCustomer2(userCode);
        } else if (role == 2) {
            userInfo = userDao.getUserIsStore(userCode);
        } else if(role == 4){
            userInfo = userDao.getUserIsDriver(userCode);
        }else if(role == 1){
            userInfo = userDao.getUserIsAdmin(userCode);
        }else if(role == 0){
            return ResponceData.success("不是角色");
        }
        if (userInfo == null) {
            return ResponceData.bizError("用户信息查询失败,请重试！");
        } else {
            return ResponceData.success("用户信息查询成功!", userInfo);
        }
    }
    /**
     * 修改密码
     * @param passwordEntity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateUserPassword(PasswordEntity passwordEntity){
        //参数是否齐全
        if(null == passwordEntity.getUserPass() || passwordEntity.getUserPass() == ""){
            return ResponceData.bizError("原密码参数为空");
        }
        if(null == passwordEntity.getCinPass() || passwordEntity.getCinPass() == ""){
            return ResponceData.bizError("新密码参数为空");
        }
        //获取当前登入编号
        passwordEntity.setUserCode(SecurityUtils.getCurrentUserId());
        //获取当前登入用户角色
        UserEntity user = userDao.queryCurrUser(passwordEntity.getUserCode());
        //设置角色
        passwordEntity.setRole(user.getUserRole());
        //新密码加密
        passwordEntity.setCinPass(PasswordUtils.generatePassword(passwordEntity.getCinPass()));
//        passWord.setUserPass(PasswordUtils.generatePassword(passWord.getUserPass()));
        //用户司机店长原来密码查询
        PasswordEntity passWordOrigin = userDao.getOrignPass(passwordEntity);
        //比较原密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //判断结果的值
        int result = 0;
        if(passwordEntity.getRole() == 4){
            //司机
            if(bCryptPasswordEncoder.matches(passwordEntity.getUserPass(),passWordOrigin.getDriverPass())){
                //密码匹配正确，进行更新
                result = userDao.updatePassWord(passwordEntity);
                if(result > 0){
                    return ResponceData.success("更新成功!");
                }
            }
            return ResponceData.bizError("原密码输入不正确!");
        }
        //店长和用户
        if(bCryptPasswordEncoder.matches(passwordEntity.getUserPass(),passWordOrigin.getUserNewPass())){
            //更改
            result = userDao.updatePassWord(passwordEntity);
            if(result > 0){
                return ResponceData.success("更新成功!");
            }
        }
        return ResponceData.bizError("原密码输入不正确!");
    }
}
