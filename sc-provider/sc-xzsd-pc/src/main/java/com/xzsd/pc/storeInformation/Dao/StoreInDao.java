package com.xzsd.pc.storeInformation.Dao;

import com.xzsd.pc.storeInformation.Entity.StoreInEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreInDao {
    /**
     * 新增门店
     * @param storeInEntity 门店信息
     * @return
     */
    int addStore(StoreInEntity storeInEntity);
    /**
     * 删除门店信息
     * @param  listCode 选中菜单编号集合
     * @return
     */
    int deleteStore(@Param("listCode") List<String> listCode, @Param("StoreID") String StoreID);
    /**
     * 查询门店信息
     * @param storeNO
     * @return 修改结果
     */
    StoreInEntity queryStoreDetail(@Param("storeNO")String storeNO);
    /**
     * 按门店编号统计门店编号
     * @param
     * @return
     */
    int countStore(String storeNO);

    /**
     * 按实体统计门店编号
     * @param
     * @return
     */
    int countStoreEntity(StoreInEntity storeInEntity);

    /**
     * 修改门店信息
     * @param storeInEntity 门店信息
     * @return 修改结果
     */
    int updatesStore(StoreInEntity storeInEntity) ;
    /**
     * 获取所有门店信息
     * @param storeInEntity 门店信息
     * @return
     */
    List<StoreInEntity>queryStoreList(StoreInEntity storeInEntity);
    /**
     * 修改角色
     */
    int updaterole(String userCode);
    /**
     * 获取店长门店信息
     * @param storeInEntity 门店信息
     * @return
     */
    List<StoreInEntity>queryStoreList2(StoreInEntity storeInEntity);
}

