package com.xzsd.pc.menu.Controller;

import com.xzsd.pc.menu.Entity.MenuEntity;
import com.xzsd.pc.menu.Service.Menuservice;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/Menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private Menuservice menuservice;
    /**
     *新增菜单
     * @param
     * @return AppResponse
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("addMenu")
    public ResponceData addMenu(MenuEntity menuEntity){
        try{
            ResponceData menuRespond = menuservice.addMenu(menuEntity);
            return  menuRespond;
        }catch (Exception e){
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查询菜单
     * @param
     * @return ResponceData
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("queryMenuDetail")
    public ResponceData queryMenuDetail(String menuNO){
        try {
            return menuservice.queryMenuDetail(menuNO);
        } catch (Exception e) {
            logger.error("用户查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除菜单
     * @param
     * @return ResponceData
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("deletemenu")
    public ResponceData deletemenu(String menuNO){
        try{
            return  menuservice.deletemenu(menuNO);
        }catch (Exception e){
            logger.error("菜单删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }
    /**
     * 修改菜单
     * @param menuEntity
     * @return ResponceData
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("updateMenu")
    public ResponceData updateMenu(MenuEntity menuEntity){
        try{
            //获取用户id
            String menuId = AuthUtils.getCurrentUmenuId();
            menuEntity.setCreate_by(menuId);
            menuEntity.setLast_modified_by(menuId);
            return menuservice.updateMenu(menuEntity);
        }catch (Exception e){
            logger.error("修改菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 菜单列表查询
     * @param
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("listMenus")
    public ResponceData listMenus(){
        try{
            return menuservice.listMenus();
        }catch (Exception e){
            logger.error("菜单列表查询错误");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 菜单列表查询
     * @param
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("listMenuHome")
    public ResponceData listMenuHome(){
        try{
            return menuservice.listMenuHome();
        }catch (Exception e){
            logger.error("菜单列表错误");
            System.out.println(e.toString());
            throw e;
        }
    }

}

