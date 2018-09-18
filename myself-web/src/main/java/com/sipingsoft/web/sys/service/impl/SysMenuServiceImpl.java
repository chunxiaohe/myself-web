package com.sipingsoft.web.sys.service.impl;

import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.web.sys.entity.SysMenu;
import com.sipingsoft.web.sys.entity.SysMenuNode;
import com.sipingsoft.web.sys.entity.SysUser;
import com.sipingsoft.web.sys.mapper.SysMenuMapper;
import com.sipingsoft.web.sys.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public ResponseMessage<SysMenuNode> getMenuList() {
		SysUser  sysUser= ShiroUtils.getLoginUser(); 
		Integer userId = sysUser.getUserId().intValue();
		//获取权限菜单
		List<SysMenuNode> rootMenu = sysMenuMapper.getMenuList(userId);
		//获取所有的一级菜单
		List<SysMenuNode> menuList = rootMenu.stream().filter(s -> s.getParentId()==0).collect(Collectors.toList());
		//获取子菜单
		menuList.forEach(s ->s.setNodes(getMemuNodes(s.getMenuId(), rootMenu)));
		return new ResponseMessage<>(menuList) ;
	}
	
	public List<SysMenuNode> getMemuNodes(Integer id, List<SysMenuNode> rootMenu) {
        // 子菜单
		List<SysMenuNode> childList = rootMenu.stream().filter(s ->id==s.getParentId()).collect(Collectors.toList());
		//把子菜单的子菜单再循环一遍
		childList.forEach(s ->s.setNodes(getMemuNodes(s.getMenuId(), rootMenu)));
        /*List<SysMenuNode> childList = new ArrayList<>();
        for (SysMenuNode menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId().equals(id)) {
                childList.add(menu);
            }
        }*/
        // 把子菜单的子菜单再循环一遍
        /*for (SysMenuNode menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getHref())) {
                // 递归
                menu.setNodes(getMemuNodes(menu.getMenuId(), rootMenu));
            }
        } */
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
