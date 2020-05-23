package com.xzsd.pc.user.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.user.services.UserService;
import com.xzsd.pc.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**

 * @author scout

 * @date 2020年4月20日

 */
@RestController
@RequestMapping("topOfColumn")
public class TopController {
    private static final Logger logger = LoggerFactory.getLogger(TopController.class);
    @Resource
    private UserService userService;
    /**
     * 获取顶部栏信息
     * @return
     */
    @PostMapping("getTopOfColumn")
    public ResponceData getTopOfColumn(){
        try {
            ResponceData appResponse=userService.getTopOfColumn();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
