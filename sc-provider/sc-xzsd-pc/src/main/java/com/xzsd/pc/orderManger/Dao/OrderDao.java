package com.xzsd.pc.orderManger.Dao;

import com.xzsd.pc.orderManger.Entity.OrderMangerEntity ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface OrderDao {
    /**
     * 订单详情查询
     * @param orderId 订单编号
     * @return
     */
    List<String>queryOrderDetail(String orderId);
    /**
     * 修改商品状态
     * @param  listCode 选中商品编号集合
     * @return
     */
    int updateOrderState(@Param("listCode") List<String> listCode, @Param("orderStatus") int orderStatus);
    /**
     * 订单列表信息分页查询
     * @param orderMangerEntity
     * @return
     */
    List<OrderMangerEntity>queryOrderList(OrderMangerEntity orderMangerEntity);

}

