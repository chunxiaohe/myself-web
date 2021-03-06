package com.cc.back.controller;


import com.cc.back.entity.SysMenuNode;
import com.cc.back.service.SysMenuService;
import com.cc.core.entity.ResponseMessage;
import com.cc.core.shiro.ShiroUtils;
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
		return sysMenuService.getMenuList(ShiroUtils.getLoginUser().getUserId().toString());
	}
}

