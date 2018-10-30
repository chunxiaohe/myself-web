package com.sipingsoft.web.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 登录
 * @author He Chunxiao
 */
@Controller
public class LoginController {

	@PostMapping("sys/login")
	public String login(String username,String password,boolean rememberMe,RedirectAttributes model){
		Subject subject = SecurityUtils.getSubject();
        //记住我
		rememberMe = false;
		UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
		try {
			subject.login(token);	
			return "redirect:/";
		} catch (UnknownAccountException e) {
		    //账号不存在
			model.addAttribute("errorMsg", "账号不存在");
		}catch (IncorrectCredentialsException e) {
            //密码错误
			model.addAttribute("errorMsg", "密码错误");
		}catch (LockedAccountException e) {
			model.addAttribute("errorMsg", "账号已被禁用");
		}catch (AuthenticationException e) {
			model.addAttribute("errorMsg","账号或密码错误");
		}
		return "redirect:/page/login";
	}
	
	/**
	 * 退出
	 * @return
	 */
	@GetMapping("/sys/loginOut")
	public String loginOut(){
		SecurityUtils.getSubject().logout();
		return "redirect:/page/login";
	}
	
	@PostMapping("/web/menuList")
	@ResponseBody
	@RequiresPermissions("web:menuList")
	public String demo(){
		System.out.println("demo");
		return "fan";
	}
}
