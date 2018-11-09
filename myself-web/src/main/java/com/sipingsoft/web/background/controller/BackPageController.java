package com.sipingsoft.web.background.controller;

import com.sipingsoft.web.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sipingsoft.core.util.PageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
