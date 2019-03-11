package com.cc.core.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ShiroSessionDao extends CachingSessionDAO{


    /**
     * 更新session
     */
	@Override
	protected void doUpdate(Session session) {
		System.out.println("更新session");
		
	}

    /**
     * 删除session
     */
	@Override
	protected void doDelete(Session session) {
		System.out.println("删除session");
		
	}

    /**
     * 创建session
     *
     */
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		System.out.println("创建session:"+sessionId);

		return sessionId;
	}

    /**
     * 根据会话ID获取会话
     *
     */
	@Override
	protected Session doReadSession(Serializable sessionId) {
		System.out.println("根据会话ID获取会话:"+sessionId);
		return null;
	}


}
