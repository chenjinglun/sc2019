package com.xzsd.app.goods.dao;

import com.xzsd.app.goods.entity.*;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;
/**
 * @Deprecated 商品详情
 * @author scout
 * @Time 2020年4月21日
 */
@Mapper
public interface GoodsDao {
    /**
     * 商品详情查询
     * @param goodsCode
     * @return
     */
    GoodsDetailEntity queryGoodDetail(@Param("goodsCode")String goodsCode);
    /**
     * 商品评价列表查询
     * @param goodsEvaEntity
     * @return
     */
    List<GoodsEVAReturnEntity>listGoodsEvaluates(GoodsEvaEntity goodsEvaEntity);
//    /**
//     * 客户绑定店铺查询
//     * @param userParam
//     * @return
//     */
//    UserBindStore queryUserBindStore(UserParam userParam);
//    /**
//     * 根据参数查询省市区名称
//     */
//    UserBindStore queryPCD(UserBindStore userBindStore);

    /**
     * @param cateCode
     * @return
     */
    List<GoodClassificationSonEntity>queryGoodClassList2(@Param("cateCode") String cateCode);
    /**
     * 查询二级分类
     */
    List<ClassifiyEntity>querySecond(@Param("cateCode") String cateCode);
}
