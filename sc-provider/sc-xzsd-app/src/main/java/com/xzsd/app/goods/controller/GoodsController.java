package com.xzsd.app.goods.controller;


import com.xzsd.app.goods.entity.GoodsEvaEntity;
import com.xzsd.app.goods.service.GoodsService;
import com.xzsd.app.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

/**
 * @Deprecated 商品详情
 * @author scout
 * @Time 2020年4月21日
 */
@RestController
@RequestMapping("/clientGoods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    @ResponseBody

    /**
     * 商品详情查询
     */
    @PostMapping("getGoods")
    public ResponceData queryGoodDetail(HttpServletRequest httpServletRequest){
        String goodsCode = httpServletRequest.getParameter("goodsCode");
        System.out.println("---------------------"+goodsCode);
        try{
            return goodsService.queryGoodDetail(goodsCode);
        } catch (Exception e){
            logger.error("商品详情查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 商品评价列表查询
     * @param goodsEvaEntity
     * @return
     */
    @PostMapping("listGoodsEvaluates")
    public ResponceData listGoodsEvaluates(GoodsEvaEntity goodsEvaEntity){
        try{
            return goodsService.listGoodsEvaluates(goodsEvaEntity);
        }catch (Exception e){
            logger.error("商品评价列表查询失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

//    /**
//     *  客户绑定店铺查询
//     * @param userParam
//     * @return
//     */
//    @PostMapping("queryUserBindStore")
//    public ResponceData queryUserBindStore(UserParam userParam){
//        try{
//            return goodDetailService.queryUserBindStore(userParam);
//        }catch (Exception e){
//            throw  e;
//        }
//    }
    /**
     * 二级分类列表以及商品查询
     * @return Response
     * @author scout
     * @Date 2020年4月21日
     */
    @RequestMapping("listGetClassGoods")
    public ResponceData listGetClassGoods(String cateCode) {
        try {
            return goodsService.listGetClassGoods(cateCode);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
