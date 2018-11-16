package com.sipingsoft.core.shiro;

import java.util.Set;

import com.sipingsoft.back.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取权限
 * @author He Chunxiao
 * @since 2018-11-1 9:36
 */
@Service
public class ShiroRelaServiceImpl implements ShiroRelamService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

	@Override
	public Set<String> findPermissions(Integer userId) {
		return sysMenuMapper.getPermissions(userId);
	}

}
