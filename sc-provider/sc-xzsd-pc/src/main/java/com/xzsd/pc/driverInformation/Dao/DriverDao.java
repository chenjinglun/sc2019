package com.xzsd.pc.driverInformation.Dao;

import com.xzsd.pc.driverInformation.Entity.DriveAreaEntity;
import com.xzsd.pc.driverInformation.Entity.DriverEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {
    /**
     * 新增门店
     * @param
     * @return
     */
    int addDrive(DriverEntity driverEntity);
    /**
     * 统计用户账号数量
     * @param
     * @return
     */
    int countUserAcct(DriverEntity driverEntity);
    int countdriverAcct(DriverEntity driverEntity);
    /**
     * 统计身份证数量
     * @param
     * @return
     */
    int countIdentify(DriverEntity driverEntity);
    int countdriverIdentify(DriverEntity driverEntity);
    /**
     * 统计电话数量
     * @param
     * @return
     */
    int countPhone(DriverEntity driverEntity);
    int countdriverPhone(DriverEntity driverEntity);
    /**
     * 删除司机信息
     * @param  listCode 选中菜单编号集合
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("driverID") String driverID);
    /**
     * 查询司机信息查询
     * @param
     * @return 修改结果
     */
    DriverEntity queryDriverDetail(@Param("driverNo")String driverNo);

    /**
     * 修改司机信息
     * @param
     * @return 修改结果
     */
    int updateDriver(DriverEntity driverEntity) ;
    /**
     * 按实体统计司机编号
     * @param
     * @return
     */
    int countdriverEntity(DriverEntity driverEntity);
    /**
     * 获取所有司机信息
     * @param driverEntity 司机信息
     * @return
     */
    List<DriverEntity>queryDriversList(DriverEntity driverEntity);
    /**
     * 获取当前登录店长所有司机信息
     * @param userCode 店长编号
     * @return
     */
    DriveAreaEntity queryDriversArea(@Param("userCode") String userCode);
    /**
     * @param driveAreaEntity
     * @return
     */
    List<DriverEntity>queryDriversList2(DriveAreaEntity driveAreaEntity);
}

