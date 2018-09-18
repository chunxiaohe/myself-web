package com.sipingsoft.core.shiro;

import org.apache.shiro.SecurityUtils;

import com.sipingsoft.web.sys.entity.SysUser;

public class ShiroUtils {

	public static SysUser getLoginUser(){
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}
}
