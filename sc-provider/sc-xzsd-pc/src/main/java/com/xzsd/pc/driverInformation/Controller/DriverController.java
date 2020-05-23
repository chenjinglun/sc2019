package com.xzsd.pc.driverInformation.Controller;

import com.xzsd.pc.driverInformation.Entity.DriverEntity ;
import com.xzsd.pc.util.AuthUtils ;
import com.xzsd.pc.util.ResponceData ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xzsd.pc.driverInformation.Service.DriverService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("driverInformation")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;
    /**
     * 新增司机信息
     * @param driverEntity
     * @return Response
     * @author scout
     * @Date 2020年4月9日14:53:26
     */
    @RequestMapping("addDriver")
    public ResponceData addDriver(DriverEntity driverEntity){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            driverEntity.setCreate_by(userId);
            ResponceData responce = driverService.addDrive(driverEntity);
            return  responce;
        }catch (Exception e){
            logger.error("新增司机信息失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 删除司机信息
     * @param
     * @return Response
     * @author scout
     * @Date 2020年4月9日
     */
    @RequestMapping("deleteDriver")
    public ResponceData deleteDriver(HttpServletRequest httpServletRequest){
        String driverCode = httpServletRequest.getParameter("listCode");
        try{
            String driverID = AuthUtils.getCurrentUmenuId();
            return  driverService.deleteDriver(driverCode,driverID);
        }catch (Exception e){
            logger.error("司机信息删除失败!",e);
            System.out.println(e.toString());
            throw e; }
    }
    /**
     * 司机详情查询
     * @return
     * @author scout
     * @Date 22020年4月9日
     */
    @RequestMapping("queryDriverDetail")
    public ResponceData queryDriverDetail(HttpServletRequest httpServletRequest){
        String driverCode = httpServletRequest.getParameter("driverNo");
        try {
            return driverService.queryDriverDetail(driverCode);
        }catch (Exception e){
            logger.error("司机详情信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改司机信息
     * @param driverEntity
     * @return Response
     * @author scout
     * @Date 2020年4月8日
     */
    @RequestMapping("updateDriver")
    public ResponceData updateDriver(DriverEntity driverEntity){
        try{
            String driverId = AuthUtils.getCurrentUserId();
            driverEntity.setLast_modified_by(driverId);
            return driverService.updateDriver(driverEntity);
        }catch (Exception e){
            logger.error("修改司机信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 司机信息列表查询
     * @param driverEntity
     * @return Response
     * @author scout
     * @Date 2020年4月8日
     */
    @RequestMapping("queryDriversList")
    public ResponceData queryDriversList(DriverEntity driverEntity) {
        try {
            return driverService.queryDriversList(driverEntity);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

