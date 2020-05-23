package com.xzsd.pc.rota.Controller;

import com.xzsd.pc.rota.Entity.Goodsquery;
import com.xzsd.pc.rota.Entity.RotaEntity;
import com.xzsd.pc.rota.Service.RotaServices;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("RotaManger")
public class RotaController {
    private static final Logger logger = LoggerFactory.getLogger(RotaController.class);
    @Resource
    private RotaServices rotaServices;
    /**
     * 新增轮播图
     * @param rotaEntity
     * @return Response
     * @author scout
     * @Date 2020年4月12日
     */
    @PostMapping("addRotaChart")
    public ResponceData addRotaChart(RotaEntity rotaEntity) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            rotaEntity.setCreate_by(userId);
            ResponceData responce =rotaServices.addRotaChart(rotaEntity);
            return  responce;
        } catch (Exception e){
            logger.error("商品新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 删除轮播图
     * @param  bannerCode
     * @return Response
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("deleteRotaChart")
    public ResponceData deleteGoods(String bannerCode){
        try{
            String RotaId = AuthUtils.getCurrentUmenuId();
            return  rotaServices.deleteRotaChart(bannerCode,RotaId);
        }catch (Exception e){
            logger.error("商品删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }
    /**
     * 分页查询
     * @param rotaEntity
     * @return Response
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("queryRotaChartList")
    public ResponceData queryRotaChartList(RotaEntity rotaEntity){
        try {
            return rotaServices.queryRotaChartList(rotaEntity);
        }catch (Exception e){
            logger.error("查询列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改轮播图状态
     * @param bannerCode,imageState
     * @return Response
     * @author scout
     * @Date 2020年4月812
     */
    @RequestMapping("updateRotaChartState")
    public ResponceData updateRotaChartState (String bannerCode,String imageState){
        String state="k";
        if(imageState.equals("1")){
            state = "2";
        }
        else if (imageState.equals("2")){
            state = "1";
        }
        try{
            return rotaServices.updateRotaChartState(bannerCode,state);
        }catch (Exception e){
            logger.error("修改商品状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改轮播图状态
     * @param goodsquery
     * @return Response
     * @author scout
     * @Date 2020年4月14日
     */
    @RequestMapping("goods")
    public ResponceData goods (Goodsquery goodsquery){
        try{
            return rotaServices.goods(goodsquery);
        }catch (Exception e){
            logger.error("查询商品失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

