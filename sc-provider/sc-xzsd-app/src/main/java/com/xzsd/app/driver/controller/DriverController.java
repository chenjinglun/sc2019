package com.xzsd.app.driver.controller;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverEntity;
import com.xzsd.app.driver.service.DriverService;
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
 * @date 2020/4/24
 */
@RestController
@RequestMapping("/driverHome")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;
    @ResponseBody
    /**
     * 司机负责门店查询
     * @return
     */
    @PostMapping("listDriverStores")
    public ResponceData listDriverStores(){
        try{
            return driverService.listDriverStores();
        }catch (Exception e){
            logger.error("司机负责门店查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 店长门下司机
     * @return
     */
    @PostMapping("listManagerDrivers")
    public ResponceData listManagerDrivers(){
        try{
            return driverService.listManagerDrivers();
        }catch (Exception e){
            logger.error("司机列表查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
