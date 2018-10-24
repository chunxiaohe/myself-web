package com.sipingsoft.web.background.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sipingsoft.core.util.PageUtil;

@Controller
public class BackPageController {
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("page/background")
	public String roleManager(){
		return "web/blank_page";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("page/background/userManager")
	public String userManager(){
		return PageUtil.USER_MANAGER_PAGE;
	}

}
