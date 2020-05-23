package com.xzsd.pc.province.Controller;


import com.xzsd.pc.province.Entity.AreaEntity;
import com.xzsd.pc.province.Service.AreaService;
import com.xzsd.pc.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
@RestController
@RequestMapping("Area")
public class AreaController {
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Resource
    private AreaService areaService;
    /**
     * 查询省
     * @param areaEntity
     * @return Response
     * @author scout
     * @Date 2020年4月7日
     */
    @RequestMapping("queryProvince")
    public ResponceData queryProvince(AreaEntity areaEntity) {
        try {
            return areaService.queryProvince(areaEntity);
        } catch (Exception e) {
            logger.error("查询省列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询市
     * @param dictCode
     * @return Response
     * @author scout
     * @Date 2020年4月7日
     */
    @RequestMapping("queryCity")
    public ResponceData queryCity(int dictCode) {
        try {
            return areaService.queryCity(dictCode);
        } catch (Exception e) {
            logger.error("查询省列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询区/县
     * @param dictCode
     * @return Response
     * @author scout
     * @Date 2020年4月7日
     */
    @RequestMapping("queryCounty")
    public ResponceData queryCounty(int dictCode) {
        try {
            return areaService.queryCounty(dictCode);
        } catch (Exception e) {
            logger.error("查询省列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

