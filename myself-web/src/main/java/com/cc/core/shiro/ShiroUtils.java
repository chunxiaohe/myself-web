package com.cc.core.shiro;

import com.cc.back.entity.SysUser;
import org.apache.shiro.SecurityUtils;


public class ShiroUtils {

	public static SysUser getLoginUser(){
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}
}
