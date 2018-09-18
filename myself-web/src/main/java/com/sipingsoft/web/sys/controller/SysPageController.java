package com.sipingsoft.web.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.web.sys.entity.SysUser;

@Controller
public class SysPageController {

	/**
	 * 登录页
	 * @return
	 */
	@GetMapping("/page/login")
	public String login(){
		return "login";
	}
	
	
	/**
	 * 主页
	 * @param map
	 * @return
	 */
	@GetMapping("/")
	public String index(ModelMap map){
		SysUser user = ShiroUtils.getLoginUser();
		map.put("username", user.getUsername());
		return "/web/index";
	}
}
