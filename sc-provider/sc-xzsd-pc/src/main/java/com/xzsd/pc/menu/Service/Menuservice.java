package com.xzsd.pc.menu.Service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.Dao.MenuDao ;
import com.xzsd.pc.menu.Entity.MenuEntity;
import com.xzsd.pc.util.ResponceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import static com.xzsd.pc.util.AuthUtils.generateMixString;
@Service
public class Menuservice {
    private ResponceData responceData;
    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     * @param menuEntity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData addMenu(MenuEntity menuEntity){
        int countmenu = menuDao.countMenuAcct(menuEntity);
        if (0 != countmenu) {
            return ResponceData.bizError("菜单已存在，请重新输入");
        }
        menuEntity.setMenuNO(generateMixString(4));
        menuEntity.setIs_deleted(0);
        int count = menuDao.addMenu(menuEntity);
        if (0 != count) {
            return ResponceData.success("新增成功！");
        }
        return ResponceData.bizError("新增失败，请重试");
    }
    /**
     * 查询菜单
     * @param
     * @return menuEntity
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData queryMenuDetail(String menuNO) {
        MenuEntity menuEntity = menuDao.queryMenuDetail(menuNO);
        if(menuEntity != null){
        return ResponceData.success("查询成功", menuEntity);}
        return ResponceData.success("查询失败");
    }
    /**
     * 删除菜单
     * @param
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deletemenu (String menuNO){
        ResponceData response = ResponceData.success("删除成功");
        //删除菜单
        int count = menuDao.deletemenu(menuNO);
        if (0 == count) {
            response = ResponceData.bizError("删除失败，请重试！");
        }
        return response;
    }
    /**
     * 修改菜单
     * @param  menuEntity
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateMenu(MenuEntity menuEntity) {
        ResponceData response = ResponceData.success("修改成功");
        //检验账号是否存在
        int countMenuAcct = menuDao.countMenuAcct(menuEntity);
        if (0 != countMenuAcct) {
            return ResponceData.bizError("菜单已存在，请重新输入！");
        }
        int count = menuDao.updateMenu( menuEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }
    /**
     * 菜单列表查询
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData listMenus(){
        List<String> menuList = menuDao.listMenus();
        return ResponceData.success("查询成功！",menuList);
    }
    /**
     * 菜单Home列表查询
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData listMenuHome() {
        List<String> menu = new ArrayList<>();
        menu.add("客户管理");
        menu.add("订单管理");
        menu.add("门店信息管理");
        menu.add("司机信息管理");
        String userCode = SecurityUtils.getCurrentUserId();
        int role = menuDao.getRole(userCode);
        if (role == 2) {
            List<String> menuListHome = menuDao.listMenuHomebyRole(menu);
            return ResponceData.success("店长列表查询成功！", menuListHome);
        }
        else if(role ==1){
            List<String> menuList = menuDao.listMenus();
            return ResponceData.success("管理员列表查询成功！",menuList);
        }
        return ResponceData.bizError("列表查询失败！");
    }
}

