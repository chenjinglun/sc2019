package com.xzsd.pc.hotGoods.HotGoodsService;

import com.xzsd.pc.hotGoods.HotGoodsDao.hotGoodsDao;
import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodsEntity;
import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodsShowNum;
import com.xzsd.pc.hotGoods.HotGoodsEntity.hotGoodslistEntity;
import com.xzsd.pc.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static com.xzsd.pc.util.AuthUtils.generateMixString;

@Service
public class hotGoodsService {
    @Resource
    private hotGoodsDao hotGoodsDao;

    /**
     * 新增热门商品
     * @param hotGoodsEntity
     * @return hotGoodsEntity
     * @Author scout
     * @Date 2020年4月14日
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addHotGood(hotGoodsEntity hotGoodsEntity) {
        //商品是否存在
        if(hotGoodsEntity.getPopSort() == 0){
            return ResponceData.bizError("位排序需指定在大于0");
        }

        if(hotGoodsDao.counthotgoodsCode(hotGoodsEntity.getSkuNo(),null)>0){

            return ResponceData.bizError("商品已经存在!");

        }
        if(hotGoodsDao.countSort(hotGoodsEntity.getPopSort(),null) > 0 ){
            return ResponceData.bizError("位排序已经存在!");
        }
        hotGoodsEntity.setProductPop(generateMixString(3));
        hotGoodsEntity.setIs_deleted(0);
        //新增商品
        int count = hotGoodsDao.addHotGood(hotGoodsEntity);
        if (0 == count) {
            return ResponceData.bizError("热门商品新增失败，请重试");
        }
        return ResponceData.success("热门商品新增成功！");
    }

    /**
     * 删除热门商品
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public  ResponceData deleteHotGood(String productPop,String hootGoodsId){
        List<String> listCode = Arrays.asList(productPop.split(","));
        ResponceData response = ResponceData.success("热门商品删除成功");
        //删除热门商品
        int count = hotGoodsDao.deleteHotGood(listCode, hootGoodsId);
        if (0 == count) {
            response = ResponceData.bizError("商品删除失败，请重试！");
        }
        return response;

    }

    /**
     * 修改热门商品信息
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月14日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateHotGood(hotGoodsEntity hotGoodsEntity) {
        ResponceData response = ResponceData.success("商品信息修改成功");
        System.out.println("----------"+hotGoodsDao.counthotgoodsCode(hotGoodsEntity.getSkuNo(),null));
        System.out.println("----------"+hotGoodsEntity.getProductPop());
        if(hotGoodsDao.counthotgoodsCode(hotGoodsEntity.getSkuNo(),hotGoodsEntity.getProductPop())>0){
            return ResponceData.bizError("热门商品已经存在!");
        }
        if(hotGoodsDao.countSort(hotGoodsEntity.getPopSort(),hotGoodsEntity.getProductPop()) > 0 ){
            return ResponceData.bizError("位排序已经存在!");
        }
        int count = hotGoodsDao.updateHotGood(hotGoodsEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 查询热门商品详情
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryHotGoodDetail(String productPop){
        hotGoodsEntity hotGoodsEntity = hotGoodsDao.queryHotGoodDetail(productPop);
        return ResponceData.success("查询成功", hotGoodsEntity);
    }

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodslistEntity
     * @Author scout
     * @Date 2020年4月14日
     */
    public ResponceData queryHotGoodsList(hotGoodslistEntity hotGoodslistEntity) {
        PageHelper.startPage(hotGoodslistEntity.getPageNum(),hotGoodslistEntity.getPageSize());
        List<hotGoodslistEntity> goodsList= hotGoodsDao.queryHotGoodsList(hotGoodslistEntity);
        // 包装Page对象
        PageInfo<hotGoodslistEntity> pageData = new PageInfo<>(goodsList);
        return ResponceData.success("查询成功！",pageData);
    }

    /**
     * 查询商品信息
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData showHotGoodsNum(){
        int hotGoodsShowNum1 = hotGoodsDao.showHotGoodsNum();
        System.out.println("------------------------"+hotGoodsShowNum1);
        return ResponceData.success("查询成功", hotGoodsShowNum1);
    }

    /**
     * 修改热门商品展示数量
     * @param hotGoodsShowNum
     * @Author scout
     * @Date 2020年4月14日18
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateHotGoodsNum(hotGoodsShowNum hotGoodsShowNum) {
        ResponceData response = ResponceData.success("商品展示数量修改成功");
        int count = hotGoodsDao.updateHotGoodsNum(hotGoodsShowNum);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

}

