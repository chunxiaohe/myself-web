package com.sipingsoft.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sipingsoft.back.entity.SysMenu;
import com.sipingsoft.back.entity.SysMenuNode;
import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.back.mapper.SysMenuMapper;
import com.sipingsoft.back.service.SysMenuService;
import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.exception.WithaleafException;
import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.core.util.EhcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
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
        //从缓存中获取数据
        List<SysMenuNode> menuList =  (List<SysMenuNode>)EhcacheUtil.getInstance().getEhcacheInfo("menuListCache","menuList");
        menuList = null;
        if(menuList == null || menuList.size()==0){
            //没有缓存从数据库中获取
            SysUser sysUser = ShiroUtils.getLoginUser();
            Integer userId = sysUser.getUserId().intValue();
            //获取权限菜单
            List<SysMenuNode> rootMenu = sysMenuMapper.getMenuList(userId);
            //获取所有的一级菜单
            menuList = rootMenu.stream().filter(s -> s.getParentId() == 0).collect(Collectors.toList());
            //获取子菜单
            menuList.forEach(s -> s.setNodes(getMemuNodes(s.getMenuId(), rootMenu)));
            //放入缓存
            EhcacheUtil.getInstance().putEhcacheInfo("menuListCache","menuList", menuList);
        }
        return new ResponseMessage<>(200, "菜单获取成功", menuList);
    }

    public List<SysMenuNode> getMemuNodes(Integer id, List<SysMenuNode> rootMenu) {
        // 子菜单
        List<SysMenuNode> childList = rootMenu.stream().filter(s -> id.equals(s.getParentId())).collect(Collectors.toList());
        //把子菜单的子菜单再循环一遍
        childList.forEach(s -> s.setNodes(getMemuNodes(s.getMenuId(), rootMenu)));
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    @Override
    public String errMsg(Integer id) {
        if (id ==1){
            throw new WithaleafException(500,"withaleaf异常");
        }else{

        return "没有异常";
        }
    }
}
