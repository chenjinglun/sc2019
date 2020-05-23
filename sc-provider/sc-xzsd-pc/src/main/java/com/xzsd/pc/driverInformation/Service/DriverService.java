package com.xzsd.pc.driverInformation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driverInformation.Entity.DriveAreaEntity;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.ResponceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xzsd.pc.driverInformation.Dao.DriverDao;
import com.xzsd.pc.driverInformation.Entity.DriverEntity;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xzsd.pc.util.AuthUtils.generateMixString;

@Service
public class DriverService {
    private ResponceData responceData;
    @Resource
    private DriverDao driverDao;
    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addDrive(DriverEntity driverEntity) {
        driverEntity.setDriverNo(generateMixString(4));
        String pwd = PasswordUtils.generatePassword(driverEntity.getDriverPwd());
        driverEntity.setDriverPwd(pwd);
        //用户是否存在
        int countUserAcct = driverDao.countUserAcct(driverEntity);
        int countdriverAccts = driverDao.countdriverAcct(driverEntity);
        if (0 != countUserAcct || countdriverAccts != 0) {
            return ResponceData.bizError("用户已存在，请重新输入");
        }
        //身份证是否一致
        int countIdentifys = driverDao.countdriverIdentify(driverEntity);
        int countIdentify = driverDao.countIdentify(driverEntity);
        if (0 != countIdentify || countIdentifys != 0) {
            return ResponceData.bizError("身份证已存在，请重新输入");
        }
        //手机号是否一致
        int countPhones = driverDao.countdriverPhone(driverEntity);
        int countPhone = driverDao.countPhone(driverEntity);
        if (0 != countPhone || countPhones != 0) {
            return ResponceData.bizError("手机号已存在，请重新输入");
        }
        driverEntity.setIs_deleted(0);
        //司机
        int count = driverDao.addDrive(driverEntity);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPwd(PasswordUtils.generatePassword(driverEntity.getDriverPwd()));
        userInfo.setUserCode(driverEntity.getDriverNo());
        userInfo.setUserAcct(driverEntity.getDriverAcct());
        userInfo.setUserName(driverEntity.getDriverName());
        userInfo.setIdCard(driverEntity.getIdCard());
        userInfo.setPhone(driverEntity.getDriverPhone());
        userInfo.setRole(4);
        int user = userDao.saveUser(userInfo);
        if (0 == count || user==0) {
            return ResponceData.bizError("司机新增失败，请重试");
        }
        return ResponceData.success("司机新增成功！");
    }
    /**
     * 删除司机
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteDriver(String driverCode,String driverID){
        List<String> listCode = Arrays.asList(driverCode.split(","));
        ResponceData response = ResponceData.success("司机信息删除成功");
        //删除菜单
        int count = driverDao.deleteDriver(listCode, driverID);
        int cnt = userDao.deleteUser(listCode, driverID);
        if (0 == count || cnt == 0) {
            response = ResponceData.bizError("司机信息删除失败，请重试！");
        }
        return response;
    }
    /**
     * 司机信息详情
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryDriverDetail(String driverNo){
        DriverEntity driverEntity = driverDao.queryDriverDetail(driverNo);
        if(driverEntity == null){
            return ResponceData.bizError("查询失败");
        }
        return ResponceData.success("查询成功",driverEntity);
    }
    /**
     * 修改司机信息
     * @param
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateDriver(DriverEntity driverEntity) {
        String pwd = PasswordUtils.generatePassword(driverEntity.getDriverPwd());
        driverEntity.setDriverPwd(pwd);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode(driverEntity.getDriverNo());
        userInfo.setUserAcct(driverEntity.getDriverAcct());
        userInfo.setUserName(driverEntity.getDriverName());
        userInfo.setUserPwd(pwd);
        userInfo.setIdCard(driverEntity.getIdCard());
        userInfo.setPhone(driverEntity.getDriverPhone());
        userInfo.setVersion(driverEntity.getVersion());
        int count = driverDao.updateDriver(driverEntity);
        int cnt = userDao.updateUser2(userInfo);
        if (0 == count || cnt == 0) {
            return ResponceData.bizError("修改失败");
        }
        else{
            return ResponceData.success("修改成功");
        }
    }

    /**
     * 查询司机信息列表（分页）
     * @param driverEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData queryDriversList(DriverEntity driverEntity) {
        PageHelper.startPage(driverEntity.getPageNum(), driverEntity.getPageSize());
        List<DriverEntity> driverList;
        //判断角色是否店长或者管理员
        if (driverEntity.getRole() == 2){
            driverEntity.setUserCode(SecurityUtils.getCurrentUserId());
            DriveAreaEntity area = driverDao.queryDriversArea(SecurityUtils.getCurrentUserId());
            driverList = driverDao.queryDriversList2(area);
        }
        else if(driverEntity.getRole() == 1){
            driverList = driverDao.queryDriversList(driverEntity);
        }
        else{
            return ResponceData.success("无权访问");
        }
        PageInfo<DriverEntity> pageData = new PageInfo<>(driverList);
        return ResponceData.success("查询成功！",pageData);
    }
}
