package com.sipingsoft.core.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

@Component
public class ShiroSessionListener implements SessionListener {

	@Override
	public void onStart(Session session) {
		System.out.println("会话开始");
	}

	@Override
	public void onStop(Session session) {
		System.out.println("会话停止");

	}

	@Override
	public void onExpiration(Session session) {
		System.out.println("会话过去");
	}

}
