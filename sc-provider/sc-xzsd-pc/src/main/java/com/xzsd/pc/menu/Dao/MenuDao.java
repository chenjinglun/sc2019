package com.xzsd.pc.menu.Dao;


import com.xzsd.pc.menu.Entity.MenuEntity ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface MenuDao {
    /**
     * 新增菜单
     * @param  menuEntity 菜单信息
     * @return
     */
    int addMenu(MenuEntity menuEntity);
    /**
     * 统计菜单数量
     * @param
     * @return
     */
    int countMenuAcct(MenuEntity menuEntity);
    /**
     * 删除菜单信息
     * @param  menuNO
     * @return
     */
    int deletemenu(String menuNO);
    /**
     * 查询菜单信息
     * @param menuNO 菜单编号
     * @return 修改结果
     */
    MenuEntity queryMenuDetail(@Param("menuNO")String menuNO);
    /**
     * 修改菜单
     * @param menuEntity 菜单信息
     * @return 修改结果
     */
    int updateMenu(MenuEntity menuEntity) ;
    /**
     * 获取所有菜单
     * @param
     * @return 菜单名字
     */
    List<String>listMenus();
    /**
     * 获取HOme所有菜单
     * @param
     * @return 菜单名字
     */
    List<String>listMenuHomebyRole(@Param("list") List<String>menu);
    /**
     * 查询当前登录ID对应的角色
     */
    int getRole(String userCode);
}

