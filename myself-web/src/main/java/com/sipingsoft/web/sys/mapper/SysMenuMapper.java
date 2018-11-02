package com.sipingsoft.web.sys.mapper;

import com.sipingsoft.web.sys.entity.SysMenu;
import com.sipingsoft.web.sys.entity.SysMenuNode;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取当前登录用户的菜单(菜单+子菜单)
     * @param userId
     * @return
     */
	@Select("SELECT sme.menu_id menuId,sme.parent_id parentId,sme.name,sme.url,sme.icon,"
			+ "sme.header,smen.`name` parentMenuName from sys_user sus "
			+"LEFT JOIN sys_user_role sur ON sus.user_id = sur.user_id "
			+"LEFT JOIN sys_role sro ON sur.role_id = sro.role_id "
			+"INNER JOIN sys_role_menu srm ON sro.role_id "
			+"INNER JOIN sys_menu sme ON sme.menu_id = srm.menu_id "
			+"LEFT JOIN sys_menu smen ON sme.parent_id = smen.menu_id "
			+"WHERE sus.user_id = #{userId} AND (sme.type = 1 OR sme.type = 2) ORDER BY sme.order_num")
	List<SysMenuNode> getMenuList(Integer userId);

    /**
     * 获取权限
     * @param userId 当前登录用户的id
     * @return 返回权限集合
     */
    @Select("SELECT sme.perms FROM "
            +"sys_user_role  sur "
            +"LEFT JOIN sys_role_menu  srm ON sur.role_id = srm.role_id "
            +"LEFT JOIN sys_menu  sme ON srm.menu_id = sme.menu_id "
            +"WHERE sur.user_id = #{userId} AND sme.type = 3 ")
    Set<String> getPermissions(Integer userId);
}
