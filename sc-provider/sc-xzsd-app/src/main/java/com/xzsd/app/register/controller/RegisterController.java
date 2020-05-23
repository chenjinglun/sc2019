package com.xzsd.app.register.controller;


import com.xzsd.app.register.entity.RegisterEntity;
import com.xzsd.app.register.service.RegisterService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author scout
 * @Desrciption 用户功能模块
 * @date 2020年4月20日
 */

@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    private RegisterService registerService;
    /***
     * @ClassName
     * @Description : 新增用户
     * @param registerEntity
     * @Author : scout
     * @Date :  2020年4月20日
     */
    @PostMapping("clientRegister")
    public  ResponceData addUser(RegisterEntity registerEntity) {
        try {
            ResponceData appResponse = registerService.addUser(registerEntity);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增用户失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
