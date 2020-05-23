package com.xzsd.app.order.controller;


import com.xzsd.app.order.service.OrderService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import com.xzsd.app.order.entity.*;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
/**
 * @author scout
 * @date 2020/20 16:27
 */
@RestController
@RequestMapping("/clientOrder")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    @ResponseBody
    /**
     * 增加订单
     */
    @PostMapping("addOrder")
    public ResponceData addOrder(addOrderEntity addOrderEntity){
        try{
            return orderService.addOrder(addOrderEntity);
        }catch (Exception e){
            logger.error("新增订单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    @PostMapping("listOrderDeepen")
    public ResponceData queryOrderDetail(OrderDetailEntity orderDetail){
        try{
            return orderService.queryOrderDetail(orderDetail);
        }catch (Exception e){
            logger.error("查询订单详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改订单状态
     * @param updateOrder
     * @return
     */
    @PostMapping("updateOrderState")
    public  ResponceData updateOrder(UpdateOrderEntitiy updateOrder) {
        try {
            return orderService.updateOrder(updateOrder);
        } catch (Exception e) {
            logger.error("修改订单状态失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 用户订单列表查询
     * @param orderListForEntitiy
     * @return
     */
    @PostMapping("listOrder")
    public ResponceData queryUserOrderList(OrderListForEntitiy orderListForEntitiy){
        try{
            return orderService.queryUserOrderList(orderListForEntitiy);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 新增订单商品评价
     * @return
     */
    @PostMapping(value = "addGoodsEvaluate",headers = {"content-type=application/json"})
    public ResponceData addOrderGoodsEva(@RequestBody OrderEvaEntity orderEvaEntity){
        try{
            return orderService.addOrderGoodsEva(orderEvaEntity);
        }catch (Exception e) {
            logger.error("新增订单评价失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 立即购买
     * @param buyNowEntity
     * @return
     */
    @PostMapping("fastBuyGoods")
    public ResponceData BuyGoods(BuyNowEntity buyNowEntity){
        try{
            return orderService.BuyGoods(buyNowEntity);
        }catch (Exception e) {
            logger.error("立即购买失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *  查询订单评价商品信息列表接口
     * @param orderCode
     */
    @PostMapping("listGoodsForEvaluate")
    public ResponceData listGoodsForEvaluate(String orderCode){
        try{
            return orderService.listGoodsForEvaluate(orderCode);
        }catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
