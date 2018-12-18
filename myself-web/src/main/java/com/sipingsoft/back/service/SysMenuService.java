package com.sipingsoft.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sipingsoft.back.entity.SysMenu;
import com.sipingsoft.back.entity.SysMenuNode;
import com.sipingsoft.core.entity.ResponseMessage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
public interface SysMenuService extends IService<SysMenu> {

	ResponseMessage<SysMenuNode> getMenuList();

    /**
     *
    统一异常异常测试
     */
	String errMsg(Integer id);
}
