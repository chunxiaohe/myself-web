package com.sipingsoft.web.sys.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.web.sys.entity.SysMenuNode;
import com.sipingsoft.web.sys.service.SysMenuService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
@RestController
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@GetMapping("/menu/getMyselfMenuList")
	public ResponseMessage<SysMenuNode> getMenuList(){
		return sysMenuService.getMenuList();
	}
}

