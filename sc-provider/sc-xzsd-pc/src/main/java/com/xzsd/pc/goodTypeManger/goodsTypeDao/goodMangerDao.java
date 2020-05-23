package com.xzsd.pc.goodTypeManger.goodsTypeDao;


import com.xzsd.pc.goodTypeManger.goodsTypeEntity.GoodClassificationEntity;
import com.xzsd.pc.goodTypeManger.goodsTypeEntity.goodMangerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface goodMangerDao {
    /**
     * 新增一级分类
     * @param goodMangerEntity
     * @return
     */
    int addFirstClass1(goodMangerEntity goodMangerEntity);
    /**
     * 统计分类名称数量
     * @param
     * @return
     */
    int counttypemanger(goodMangerEntity goodMangerEntity);
    /**
     * 新增二分类
     * @param goodMangerEntity
     * @return
     */
    int addSecondClass2(goodMangerEntity goodMangerEntity);
    /**
     * 删除分类信息
     * @param  cateCode
     * @return
     */
    int deleteGoodClass(String cateCode);
    /**
     * 修改分类信息
     * @param
     * @return 修改结果
     */
    int updateGoodClass(goodMangerEntity goodMangerEntity) ;
    /**
     * 分类信息查询
     * @param
     * @return 修改结果
     */
    goodMangerEntity queryGoodClass(@Param("cateCode")String cateCode);
    /**
     * 按分类编号 统计编号
     * @param
     * @return
     */
    int countType(String cateCode);
    /**
     * 分类列表信息查询
     * @param goodMangerEntity 分类实体
     * @return
     */
    List<goodMangerEntity>queryGoodClassList1(goodMangerEntity goodMangerEntity);
    List<Integer>queryGoodClassList2(String cateCode);
    /**
     * 商品分类列表查询
     * @return
     */
    List<GoodClassificationEntity> queryGoodClassList();
}

