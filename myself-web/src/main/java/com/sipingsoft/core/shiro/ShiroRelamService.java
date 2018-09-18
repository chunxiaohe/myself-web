package com.sipingsoft.core.shiro;

import java.util.Set;

public interface ShiroRelamService {
	
	/**
     * 根据Id查找权限字符串
     * @param userId
     * @return
     */
    Set<String> findPermissions(Long userId);
}
