package com.xzsd.pc.goodTypeManger.goodsTypeService;

import com.xzsd.pc.goodTypeManger.goodsTypeEntity.GoodClassificationEntity;
import com.xzsd.pc.goodTypeManger.goodsTypeEntity.GoodClassificationListEntity;
import com.xzsd.pc.goodTypeManger.goodsTypeEntity.GoodClassificationSonEntity;
import com.xzsd.pc.goodTypeManger.goodsTypeEntity.goodMangerEntity;
import com.xzsd.pc.goodTypeManger.goodsTypeDao.goodMangerDao;
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
public class goodMangerService {
    private ResponceData responceData;
    @Resource
    private goodMangerDao goodMangerDao;
    /**
     * 新增一级分类
     * @param goodMangerEntity
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addFirstClass1(goodMangerEntity goodMangerEntity) {
        //分类名称是否存在
        int counttypemanger = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != counttypemanger) {
            return ResponceData.bizError("分类已存在，请重新输入");
        }
        goodMangerEntity.setIs_deleted(0);
        goodMangerEntity.setCateCode(generateMixString(6));
        //新增门店
        int count = goodMangerDao.addFirstClass1(goodMangerEntity);
        if (0 == count) {
            return ResponceData.bizError("一级分类新增失败，请重试");
        }
        return ResponceData.success("一级分类新增成功！");
    }

    /**
     * 新增二级分类
     * @param goodMangerEntity
     * @return     * @Author scout
     * @Date 2020年4月7日09:59:41
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addSecondClass2(goodMangerEntity goodMangerEntity) {
        //分类名称是否存在
        int countsecondtypemanger = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != countsecondtypemanger) {
            return ResponceData.bizError("分类已存在，请重新输入");
        }
        goodMangerEntity.setIs_deleted(0);
        goodMangerEntity.setCateCode(generateMixString(6));
        //新增二级分类
        int count = goodMangerDao.addSecondClass2(goodMangerEntity);
        if (0 == count) {
            return ResponceData.bizError("二级分类新增失败，请重试");
        }
        return ResponceData.success("二级分类新增成功！");
    }
    /**
     * 删除分类
     * @param cateCode
     * @Author scout
     * @Date 2020年4月10日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteGoodClass(String cateCode){
        ResponceData response = ResponceData.success("分类删除成功");
        //删除分类
        int count = goodMangerDao.deleteGoodClass(cateCode);
        if (0 == count) {
            response = ResponceData.bizError("分类删除失败，请重试！");
        }
        return response;
    }
    /**
     * 修改分类信息
     * @param goodMangerEntity
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateGoodClass(goodMangerEntity goodMangerEntity) {
        ResponceData response = ResponceData.success("修改分类信息成功");
        //分类名称是否存在
        int countName = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != countName) {
            return ResponceData.bizError("分类名称已存在，请重新输入");
        }
        int count = goodMangerDao.updateGoodClass(goodMangerEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }
    /**
     * 查询分类详情信息
     * @param cateCode
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryGoodClass(String cateCode){
        goodMangerEntity goodMangerEntity = goodMangerDao.queryGoodClass(cateCode);

        int countTypes = goodMangerDao.countType(cateCode);
        if (0 == countTypes) {
            return ResponceData.bizError("分类不存在，请重新输入");
        }
        return ResponceData.success("查询成功", goodMangerEntity);
    }
    /**
     * 查询一级分类信息
     * @param goodMangerEntity
     * @return goodMangerEntity
     * @Author scout
     * @Date 2020年4月10日
     */
    public ResponceData queryGoodClassList1(goodMangerEntity goodMangerEntity) {

        List<goodMangerEntity> goodTypeList= goodMangerDao.queryGoodClassList1(goodMangerEntity);
        return ResponceData.success("查询成功！",goodTypeList);
    }
    /**
     * 查询二级分类信息
     * @param cateCode
     * @return goodMangerEntity
     * @Author scout
     * @Date 2020年4月10日
     */
    public ResponceData queryGoodClassList2(String cateCode) {

        List<Integer> goodTypeList2= goodMangerDao.queryGoodClassList2(cateCode);
        return ResponceData.success("查询成功！",goodTypeList2);
    }
    /**
     * 商品分类列表查询[采用循环实现]
     * @return
     */
    public ResponceData queryGoodClassList3(){
        //查询所有，然后分类
        List<GoodClassificationEntity>goodClassificationLists = goodMangerDao.queryGoodClassList();
        //输出给前台的 最终数据
        List<GoodClassificationListEntity> goodClassificationListsOut = new ArrayList<>();
        //从插到的所有结果找，如果有一级分类，那么就存到 暂时容器里
        for(int i = 0;i < goodClassificationLists.size();i++){
            if(null == goodClassificationLists.get(i).getClassRank()){continue;}
            //如果是一级分类，那么进行查找他所对应的二级分类
            if(goodClassificationLists.get(i).getClassRank().equals("1")){
                GoodClassificationListEntity goodClassificationList = new GoodClassificationListEntity();
                goodClassificationList.setClassCode(goodClassificationLists.get(i).getClassCode());
                goodClassificationList.setClassName(goodClassificationLists.get(i).getClassName());
                goodClassificationList.setVersion(goodClassificationLists.get(i).getVersion());
                //查找直系的二级
                int count = 0;
                List<GoodClassificationSonEntity>goodClassificationSonList =  new ArrayList<>();
                //遍历所有结果，且不包括他自己
                for(int j = 0;j< goodClassificationLists.size();j++){
                    if(j == i){ continue;}
                    if(null == goodClassificationLists.get(j).getFirstClassCode()){continue;}
                    //如果这个二级分类的父结点等于上面的一级分类的编号，那么将这个结点放到上面的暂时容器里。
                    if(goodClassificationLists.get(j).getFirstClassCode().equals(goodClassificationLists.get(i).getClassCode())){
                        GoodClassificationSonEntity goodClassificationSon = new GoodClassificationSonEntity();
                        goodClassificationSon.setClassCode(goodClassificationLists.get(j).getClassCode());
                        goodClassificationSon.setClassName(goodClassificationLists.get(j).getClassName());
                        goodClassificationSon.setVersion(goodClassificationLists.get(j).getVersion());
                        goodClassificationSonList.add(goodClassificationSon);
                    }
                }
                goodClassificationList.setListGoodClassificationSon(goodClassificationSonList);
                //将 找到的第i个一级分类以及所属的二级分类存到 输出容器里。
                goodClassificationListsOut.add(goodClassificationList);
            }
        }
        //判断查询的结果
        if(goodClassificationListsOut.size()>0){
            return ResponceData.success("查询成功!",goodClassificationListsOut);
        }
        return ResponceData.bizError("查询为空!");
    }
}
