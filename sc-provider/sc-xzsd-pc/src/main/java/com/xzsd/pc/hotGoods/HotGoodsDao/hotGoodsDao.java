package com.xzsd.pc.hotGoods.HotGoodsDao;


import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodsEntity;
import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodslistEntity;
import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodsShowNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface hotGoodsDao {
    /**
     * 统计商品数量
     * @param productPop skuNo
     * @return
     */
    int counthotgoodsCode(@Param("skuNo")String skuNo,@Param("productPop")String productPop);
    /**
     * 统计排序
     * @param  productPop popSort
     * @return
     */
    int countSort(@Param("popSort") int sort,@Param("productPop")String productPop);
    /**
     * 新增热门商品
     * @param hotGoodsEntity
     * @return
     */
    int addHotGood(hotGoodsEntity hotGoodsEntity);
    /**
     * 删除热门商品信息
     * @param  listCode 选中热门商品号集合
     * @return
     */
    int deleteHotGood(@Param("listCode") List<String> listCode, @Param("hootGoodsId") String hootGoodsId);
    /**
     * 修改热门商品信息
     * @param hotGoodsEntity 热门商品信息
     * @return 修改结果
     */
    int updateHotGood(hotGoodsEntity hotGoodsEntity) ;

    /**
     * 查询热门商品详情信息
     * @param productPop
     * @return 修改结果
     */
    hotGoodsEntity queryHotGoodDetail(@Param("productPop")String productPop);
    /**
     * 热门商品列表信息分页查询
     * @param hotGoodslistEntity 热门商品信息
     * @return
     */
    List<hotGoodslistEntity>queryHotGoodsList(hotGoodslistEntity hotGoodslistEntity);

    /**
     * 展示数量
     * @param
     * @return
     */
    int showHotGoodsNum();

    /**
     * 修改热门商品展示数量
     * @param hotGoodsShowNum
     * @return 修改结果
     */
    int updateHotGoodsNum(hotGoodsShowNum hotGoodsShowNum) ;

}

