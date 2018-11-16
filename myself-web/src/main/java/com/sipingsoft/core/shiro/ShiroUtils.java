package com.sipingsoft.core.shiro;

import com.sipingsoft.back.entity.SysUser;
import org.apache.shiro.SecurityUtils;


public class ShiroUtils {

	public static SysUser getLoginUser(){
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}
}
