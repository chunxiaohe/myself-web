package com.sipingsoft.web.background.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sipingsoft.core.util.PageUtil;

/**
 * 页面跳转controller
 * @author He Chunxiao
 */
@Controller
public class BackPageController {
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("view/indexcontent")
	public String roleManager(){
		return PageUtil.INDEX_PAGE;
	}

    @GetMapping("page2/background")
    public String roleManager2(){
        return "web/inline_editors";
    }
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("page/background/userManager")
	public String userManager(){
		return PageUtil.USER_MANAGER_PAGE;
	}

    /**
     * 404页面
     * @return
     */
	@GetMapping("/page/backend/404-page")
    public String error404(){
	    return PageUtil.ERROR_404;
    }



}
