package com.xzsd.app.userInformation.controller;

import com.xzsd.app.userInformation.entity.PasswordEntity;
import com.xzsd.app.userInformation.service.UserInformationService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * @author scout
 * @date 2020/4/15 16:27
 */
@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);
    @Resource
    private UserInformationService userService;
    @PostMapping("getUser")
    public ResponceData getUser(){
        try {
            ResponceData appResponse = userService.getUser();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
    /**
     * 修改密码
     * @param passwordEntity
     * @return
     */
    @PostMapping("updateUserPassword")
    public ResponceData updateUserPassword(PasswordEntity passwordEntity){
        try {
            ResponceData reced = userService.updateUserPassword(passwordEntity);
            return reced;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
