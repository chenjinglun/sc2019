package com.xzsd.pc.storeInformation.Service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.storeInformation.Dao.StoreInDao;
import com.xzsd.pc.storeInformation.Entity.StoreInEntity;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.xzsd.pc.util.AuthUtils.generateMixString;

@Service
public class StoreInService {
    private ResponceData responceData;
    @Resource
    private StoreInDao storeInDao;
    @Resource
    private UserDao userDao;
    /**
     * 新增门店
     *
     * @param storeInEntity
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */


    @Transactional(rollbackFor = Exception.class)
    public ResponceData addStore(StoreInEntity storeInEntity) {
        //门店是否存在
//        int countUserAcct = storeInDao.countStoreEntity(storeInEntity);
//        if (0 != countUserAcct) {
//            return ResponceData.bizError("用户已存在，请重新输入");
//        }
        String userCode=storeInEntity.getUserCode();
        int countUsercode = userDao.countUsercode(userCode);
        if (0 == countUsercode) {
            return ResponceData.bizError("店长编号不存在，请重新输入");
        }
        else {
            int sd = storeInDao.updaterole(userCode);
            storeInEntity.setStoreNO(generateMixString(4));
            storeInEntity.setStoreInvitation(generateMixString(6));
            storeInEntity.setIs_deleted(0);
            //新增门店
            int count = storeInDao.addStore(storeInEntity);
            if (0 == count || sd == 0) {
                return ResponceData.bizError("门店新增失败，请重试");
            }
            return ResponceData.success("门店成功！");
        }
    }
    /**
     * 删除门店
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteStore(String StoreCode,String StoreID){
        //System.out.println(menuCode+","+menuId);
        List<String> listCode = Arrays.asList(StoreCode.split(","));
//        List<Integer> listCode2 = new ArrayList<>();
//        for(String str : listCode){
//            //System.out.println(str);
//            int i = Integer.parseInt(str);
//            listCode2.add(i);
//        }
        ResponceData response = ResponceData.success("门店删除成功");
        //删除菜单
        int count = storeInDao.deleteStore(listCode, StoreID);
        //demoDao.deleteUser(listCode,userId);
        if (0 == count) {
            response = ResponceData.bizError("门店删除失败，请重试！");
        }
        return response;
    }
    /**
     * 查询门店信息
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryStoreDetail(String storeNO){
        StoreInEntity storeInEntity = storeInDao.queryStoreDetail(storeNO);
        int countstoreNo = storeInDao.countStore(storeNO);
//        System.out.println(countstoreNo+"--------------------------");
        if (0 == countstoreNo) {
            return ResponceData.bizError("门店已删除，请重新输入");
        }
        return ResponceData.success("查询成功", storeInEntity);
    }
    /**
     * 修改门店信息
     * @param storeInEntity
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updatesStore(StoreInEntity storeInEntity) {
        ResponceData response = ResponceData.success("修改成功");
        int count = storeInDao.updatesStore(storeInEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }
    /**
     * demo 查询门店列表（分页）
     * @param storeInEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData queryStoreList(StoreInEntity storeInEntity) {
        PageHelper.startPage(storeInEntity.getPageNum(), storeInEntity.getPageSize());
        //判断角色是否管理员还是店长
        List<StoreInEntity> storeList ;
        storeInEntity.setUserCode(SecurityUtils.getCurrentUserId());
        if (storeInEntity.getRole() == 2){
            storeList = storeInDao.queryStoreList2(storeInEntity);
        }
        else if(storeInEntity.getRole() == 1){
            storeList = storeInDao.queryStoreList(storeInEntity);
        }
        else{
            return ResponceData.success("无权访问");
        }
        PageInfo<StoreInEntity> pageData = new PageInfo<>(storeList);
        return ResponceData.success("查询成功！",pageData);
    }

}
