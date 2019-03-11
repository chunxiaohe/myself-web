package com.cc.core.shiro;

import java.util.Set;

/**
 * 权限获取接口
 * @author He Chunxiao
 * @since  2018-11-1 9:36
 */
public interface ShiroRelamService {
	
	/**
     * 根据Id查找权限字符串
     * @param userId
     * @return
     */
    Set<String> findPermissions(Integer userId);
}
