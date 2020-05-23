package com.xzsd.pc.rota.Dao;

import com.xzsd.pc.rota.Entity.Goodsquery;
import com.xzsd.pc.rota.Entity.RotaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface RotaDao {
    /**
     * 新增轮播图
     * @param rotaEntity
     * @return
     */
    int addRotaChart(RotaEntity rotaEntity);
    /**
     * 删除轮播图
     * @param listCode
     * @param RotaId
     * @return
     */
    int deleteRotaChart(@Param("listCode") List<String> listCode, @Param("RotaId") String RotaId);
    /**
     * 查询轮播图列表
     * @param rotaEntity
     * @return
     */
    List<RotaEntity>queryRotaChartList(RotaEntity rotaEntity);
    /**
     * 修改轮播图状态
     * @param  listCode 选中商品编号集合
     * @return
     */
    int updateRotaChartState(@Param("listCode") List<String> listCode, @Param("imageState") String imageState);
    /**
     * 商品列表查询
     * @param goodsquery
     * @return
     */
    List<Goodsquery>goods(Goodsquery goodsquery);
}

