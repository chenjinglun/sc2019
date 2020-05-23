package com.xzsd.app.Homepage.controller;


import com.xzsd.app.Homepage.service.HomeService;
import com.xzsd.app.util.ResponceData ;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import javax.annotation.Resource;

/**
 * 首页Controller类
 */
@RestController
@RequestMapping("/clientHome")
public class HomeController {
    @Resource
    private HomeService homeService;
    @ResponseBody
    /**
     * 首页-轮播图
     */
    @PostMapping("listRotationCharHome")
    public ResponceData queryRotate(){
        try{
            return homeService.queryRotate();
        }catch (Exception e){
            throw e;

        }
    }
    /**
     * 热门商品列表查询
     * @return
     */
    @PostMapping("listHotGoods")
    public ResponceData queryHotGoods(){
        try{
            return homeService.queryHotGoods();
        }catch (Exception e){
            throw e;
        }
    }
}
