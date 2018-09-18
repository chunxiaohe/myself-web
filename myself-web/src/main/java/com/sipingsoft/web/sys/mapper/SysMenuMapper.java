package com.sipingsoft.web.sys.mapper;

import com.sipingsoft.web.sys.entity.SysMenu;
import com.sipingsoft.web.sys.entity.SysMenuNode;

import java.util.List;

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
	
	@Select("SELECT sme.menu_id menuId,sme.parent_id parentId,sme.name,sme.url,sme.icon,"
			+ "sme.header,smen.`name` parentMenuName from sys_user sus "
			+"LEFT JOIN sys_user_role sur ON sus.user_id = sur.user_id "
			+"LEFT JOIN sys_role sro ON sur.role_id = sro.role_id "
			+"INNER JOIN sys_role_menu srm ON sro.role_id "
			+"INNER JOIN sys_menu sme ON sme.menu_id = srm.menu_id "
			+"LEFT JOIN sys_menu smen ON sme.parent_id = smen.menu_id "
			+"WHERE sus.user_id = #{userId} ORDER BY sme.order_num")
	List<SysMenuNode> getMenuList(Integer userId);
}
