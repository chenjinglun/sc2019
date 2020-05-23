package com.xzsd.app.driver.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverEntity;
import com.xzsd.app.driver.entity.DriverListOutEntity;
import com.xzsd.app.driver.entity.StoreOutEntity;
import com.xzsd.app.util.ResponceData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    /**
     * 司机负责门店信息列表查询
     * @return
     */
    public ResponceData listDriverStores() {
        DriverEntity Area = driverDao.queryArea(SecurityUtils.getCurrentUserId());
        List<DriverListOutEntity> driverListOut = driverDao.queryStore(Area);
        if (driverListOut.size() == 0){
            return ResponceData.bizError("司机负责门店信息列表查询失败");
        }
        return ResponceData.success("查询成功",driverListOut);
    }
    /**
     * 店长门下司机信息查询
     * @return
     */
    public ResponceData listManagerDrivers() {
        DriverEntity Area2 = driverDao.queryArea2(SecurityUtils.getCurrentUserId());
        List<StoreOutEntity> StoreListOut = driverDao.queryStore2(Area2);
        if (StoreListOut.size() == 0){
            return ResponceData.bizError("店长门下司机查询失败");
        }
        return ResponceData.success("查询成功",StoreListOut);
    }
}
