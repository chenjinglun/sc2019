package com.xzsd.app.Homepage.dao;

import com.xzsd.app.Homepage.entity.HotGoods;
import com.xzsd.app.Homepage.entity.RotaImageEntity;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface HomeDao {
    /**
     * 首页轮播图列表
     * @return
     */
    List<RotaImageEntity> queryRotate();
    /**
     * 首页热门商品列表
     * @return
     */
    List<HotGoods>queryHotGoodsList(@Param("num")int num);
    /**
     * 删除那些不在这list列表的轮播图
     * @param code
     * @return
     */
    int deletenoCode(@Param("list")List<String>code);
    /**
     * 查询展示数量
     * @return
     */
    int queryNum();
}
