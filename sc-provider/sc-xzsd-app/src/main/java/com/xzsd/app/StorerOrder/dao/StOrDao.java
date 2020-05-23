package com.xzsd.app.StorerOrder.dao;

import com.xzsd.app.StorerOrder.entity.OrderDetailEntity;
import com.xzsd.app.StorerOrder.entity.StOrForListEntity;
import com.xzsd.app.StorerOrder.entity.StOrListEntity;
import com.xzsd.app.StorerOrder.entity.updateStateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StOrDao {
    /**
     * 更细订单状态
     * @param updateStateEntity
     * @return
     */
    int updateState(updateStateEntity updateStateEntity);
    /**
     * 店长订单列表查询
     * @param stOrForList
     * @return
     */
    List<StOrListEntity> listManagerOrders(StOrForListEntity stOrForList);
    /**
     * 订单详情查询
     * @param orderCode
     * @return
     */
    OrderDetailEntity queryshopOwnerOrderDetail(@Param("orderCode")String orderCode);
}
