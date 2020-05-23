package com.xzsd.app.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.*;
import com.xzsd.app.util.ResponceData;
import com.xzsd.app.util.ResponceDataState;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Deprecated 商品详情
 * @author scout
 * @Time 2020年4月21日
 */
@Service
public class GoodsService {
    /**
     * 商品详情查询
     * @param httpServletRequest
     * @return
     */
    @Resource
    private GoodsDao goodsDao;
    public ResponceData queryGoodDetail(String goodsCode){
        //判断，如果参数编号为空，那么提示并返回结果
        if (null == goodsCode) {
            return ResponceData.bizError("商品编号为空，请重新输入");
        }
        //查询
        GoodsDetailEntity goodsData = goodsDao.queryGoodDetail(goodsCode);
        if(null == goodsData){
            return ResponceData.bizError("商品查询失败！");
        }
        return ResponceData.success("查询成功", goodsData);
    }
    /**
     * 商品评价列表查询
     * @param goodsEvaEntity
     * @return
     */
    public ResponceData listGoodsEvaluates(GoodsEvaEntity goodsEvaEntity){
        //查询
        PageHelper.startPage(goodsEvaEntity.getPageNum(),goodsEvaEntity.getPageSize());
        List<GoodsEVAReturnEntity> goodEvaList = goodsDao.listGoodsEvaluates(goodsEvaEntity);
        PageInfo<GoodsEVAReturnEntity>goodEvaPageInfo = new PageInfo<>(goodEvaList);
        if(goodEvaList.size() > 0){
            return ResponceData.success("查询成功", goodEvaPageInfo);
        }
        return ResponceData.bizError("商品查询失败！");
    }
    /**
     * 二级分类列表以及商品查询
     * @return Response
     * @author scout
     * @Date 2020年4月21日
     */
    public ResponceData listGetClassGoods(String cateCode) {
        List<ClassifiyEntity> cate = goodsDao.querySecond(cateCode);
        //输出给前台的 最终数据
        List<GoodsListOutEntity> goodClassificationListsOut = new ArrayList<>();
        for(int i =0 ;i < cate.size(); i++){
            GoodsListOutEntity demo = new GoodsListOutEntity();
            demo.setClassCode(cate.get(i).getClassCode());
            demo.setClassName(cate.get(i).getClassName());
            List<GoodClassificationSonEntity> goodsList = goodsDao.queryGoodClassList2(cate.get(i).getClassCode());
            if(goodsList != null){
                demo.setListGoodClassificationSon(goodsList);
            }
            goodClassificationListsOut.add(demo);
        }
        return ResponceData.success("查询成功！",goodClassificationListsOut);
    }
}
