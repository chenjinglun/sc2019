package com.xzsd.app.updateInvitation.controller;


import com.xzsd.app.updateInvitation.entity.UpdateEntity;
import com.xzsd.app.updateInvitation.service.UpdateService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author scout
 * @date 2020/4/15
 */
@RestController
@RequestMapping("/clientInformation")
public class UpdateController {
    private static final Logger logger = LoggerFactory.getLogger(UpdateController.class);
    @Resource
    private UpdateService updateService;

    @ResponseBody
    /**
     * 修改邀请码密码
     * @param investCode
     * @return
     */
    @PostMapping("updateClientInvite")
    public ResponceData updateClientInvite(UpdateEntity updateEntity) {
        try {
            return updateService.updateClientInvite(updateEntity);
        } catch (Exception e) {
            logger.error("修改邀请码查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
