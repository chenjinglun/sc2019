package com.xzsd.app.StorerOrder.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.StorerOrder.dao.StOrDao;
import com.xzsd.app.StorerOrder.entity.OrderDetailEntity;
import com.xzsd.app.StorerOrder.entity.StOrForListEntity;
import com.xzsd.app.StorerOrder.entity.StOrListEntity;
import com.xzsd.app.StorerOrder.entity.updateStateEntity;
import com.xzsd.app.util.ResponceData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author scout
 * @date 2020/4/15
 */
@Service
public class StOrService {
    @Resource
    private StOrDao stOrDao;
    /**
     * 订单状态更新
     * @param updateStateEntity
     * @return
     */
    public ResponceData updateState(updateStateEntity updateStateEntity){
        if(null == updateStateEntity.getOrderCode()){
            return  ResponceData.bizError("订单编号为空");
        }
        int result = stOrDao.updateState(updateStateEntity);
        if(result > 0){
            return ResponceData.success("订单状态更新成功!",result);
        }
        return ResponceData.bizError("订单状态修改失败");
    }
    /**
     * 店长-订单列表查询
     * @param stOrForList
     * @return
     */
    public ResponceData listManagerOrders(StOrForListEntity stOrForList){
        //获取店长编号
        stOrForList.setUserCode(SecurityUtils.getCurrentUserId());
        //获取信息
        List<StOrListEntity> orderList = stOrDao.listManagerOrders(stOrForList);
        if(orderList.size() > 0){
            return ResponceData.success("查询成功!",orderList);
        }
        return ResponceData.bizError("查询为空");
    }
    /**
     * 2 店长订单详情查询
     * @param orderDetail
     * @return
     */
    public ResponceData queryOrderDetail(OrderDetailEntity orderDetail){
        if(null == orderDetail.getOrderCode() || orderDetail.getOrderCode() == ""){
            return ResponceData.bizError("订单编号参数缺失!");
        }
        //查询
        OrderDetailEntity orderDetailOut = stOrDao.queryshopOwnerOrderDetail(orderDetail.getOrderCode());
        //判断结果
        if(null != orderDetailOut){
            return ResponceData.success("查询成功!",orderDetailOut);
        }
        return ResponceData.bizError("查询为空");
    }
}
