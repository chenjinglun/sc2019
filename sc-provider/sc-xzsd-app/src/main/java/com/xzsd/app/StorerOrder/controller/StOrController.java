package com.xzsd.app.StorerOrder.controller;
import com.xzsd.app.StorerOrder.entity.OrderDetailEntity;
import com.xzsd.app.StorerOrder.entity.StOrForListEntity;
import com.xzsd.app.StorerOrder.entity.updateStateEntity;
import com.xzsd.app.StorerOrder.service.StOrService;
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
@RequestMapping("/managerOrder")
public class StOrController {
    private static final Logger logger = LoggerFactory.getLogger(StOrController.class);
    @Resource
    private StOrService stOrService;
    /**
     * 店长订单状态修改
     * @param updateStateEntity
     * @return
     */
    @ResponseBody
    @PostMapping("updateManagerOrderState")
    public ResponceData updateState(updateStateEntity updateStateEntity) {
        try {
            return stOrService.updateState(updateStateEntity);
        } catch (Exception e) {
            logger.error("订单状态修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 店长-订单列表查询
     * @param stOrForList
     * @return
     */
    @PostMapping("listManagerOrders")
    public ResponceData listManagerOrders(StOrForListEntity stOrForList){
        try{
            return stOrService.listManagerOrders(stOrForList);
        } catch (Exception e) {
            logger.error("店长订单列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    @PostMapping("listManagerOrderDeepen")
    public ResponceData queryOrderDetail(OrderDetailEntity orderDetail){
        try{
            return stOrService.queryOrderDetail(orderDetail);
        }catch (Exception e) {
            logger.error("订单详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

