package com.sipingsoft.back.controller;


import com.sipingsoft.back.entity.SysMenuNode;
import com.sipingsoft.back.service.SysMenuService;
import com.sipingsoft.core.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

