package com.cc.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.back.entity.SysMenu;
import com.cc.back.entity.SysMenuNode;
import com.cc.back.entity.SysUser;
import com.cc.back.mapper.SysMenuMapper;
import com.cc.back.service.SysMenuService;
import com.cc.core.entity.ResponseMessage;
import com.cc.core.exception.WithaleafException;
import com.cc.core.shiro.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import com.cc.core.util.EhcacheUtil;

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

    /**
     * 使用@cacheable注解就不需要自己手动往ehcache中添加缓存和手动取缓存
     *
     * @return
     */
    @Override
    @Cacheable(value = "menuListCache",key = "'userid_'+#id")
    public ResponseMessage<SysMenuNode> getMenuList(String id) {
        //从缓存中获取数据
        // List<SysMenuNode> menuList =  (List<SysMenuNode>)EhcacheUtil.getInstance().getEhcacheInfo("menuListCache","menuList");
        List<SysMenuNode> menuList = null;
        if (menuList == null || menuList.size() == 0) {
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
            // EhcacheUtil.getInstance().putEhcacheInfo("menuListCache","menuList", menuList);
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
        if (id == 1) {
            throw new WithaleafException(500, "withaleaf异常");
        } else {
            return "没有异常";
        }
    }
}
