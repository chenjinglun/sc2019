package com.xzsd.app.Homepage.service;

import com.xzsd.app.Homepage.dao.HomeDao;
import com.xzsd.app.Homepage.entity.HotGoods;
import com.xzsd.app.Homepage.entity.RotaImageEntity;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * @Deprecated 首页service
 * @author  scout
 * @Time 2020年4月21日
 */
@Service
public class HomeService {
    @Resource
    private HomeDao homeDao;
    /**
     * 热门轮播图列表查询
     * @return
     */
    public ResponceData queryRotate(){
        List<RotaImageEntity> rotaList = homeDao.queryRotate();
        if(rotaList.size() > 0){
            String msg = "";
            //删掉过期轮播图
            List<String>noCodes = new ArrayList<>();
            for(int i = 0;i < rotaList.size() ; i++){
                noCodes.add(rotaList.get(i).getBannerCode());
            }
            //进行删除
            int result = homeDao.deletenoCode(noCodes);
            if(result > 0){
                msg = "已更新过期的轮播图"+result+"个";
            }
            return ResponceData.success("查询成功！", rotaList);
        }
        return ResponceData.bizError("新增失败，请重试");
    }
    /**
     * 热门商品
     * @return
     */
    public ResponceData queryHotGoods(){
        //先查询展示的数量
        int num = homeDao.queryNum();
        //查询
        List<HotGoods>hotGoodsList = homeDao.queryHotGoodsList(num);
        if(hotGoodsList.size() > 0){
            return new ResponceData(ResponceDataState.values()[0].getCode(),"获取成功!",hotGoodsList);
        }
        return new ResponceData(ResponceDataState.values()[3].getCode(),"获取热门商品列表失败",null);
    }
}
