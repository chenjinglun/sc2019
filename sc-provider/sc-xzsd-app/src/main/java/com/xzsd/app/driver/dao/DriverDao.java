package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverEntity;
import com.xzsd.app.driver.entity.DriverListOutEntity;
import com.xzsd.app.driver.entity.StoreOutEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {
    /**
     * 查询当前登录司机所在省市区
     */
    DriverEntity queryArea(@Param("DriverCode") String DriverCode);
    /**
     * 查询负责门店
     */
    List<DriverListOutEntity>queryStore(DriverEntity driverEntity);
    /**
     * 查询当前登录店长所在省市区
     */
    DriverEntity queryArea2(@Param("userCode") String userCode);
    /**
     * 店长门店下的司机
     */
    List<StoreOutEntity>queryStore2(DriverEntity driverEntity);
}
