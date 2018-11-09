package com.sipingsoft.web.sys.service;

import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.web.sys.entity.SysMenu;
import com.sipingsoft.web.sys.entity.SysMenuNode;
import com.baomidou.mybatisplus.service.IService;

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
	String errMsg( Integer id);
}
