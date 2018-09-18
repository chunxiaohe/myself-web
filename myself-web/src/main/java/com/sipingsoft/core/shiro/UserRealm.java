package com.sipingsoft.core.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sipingsoft.web.sys.entity.SysUser;
import com.sipingsoft.web.sys.mapper.SysUserMapper;


@Component
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private ShiroRelamService shiroReamService;
	
	/**
	 *授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权");
		SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
		Set<String> permissions = shiroReamService.findPermissions(sysUser.getUserId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		//String pwd = new SimpleHash("MD5",token.getPassword(),token.getUsername(),1).toString();//密码加密
		SysUser sysUser = new SysUser();
		sysUser.setUsername(token.getUsername());
		SysUser user = sysUserMapper.selectOne(sysUser);
		if(user==null){
			throw new UnknownAccountException("用户名或账号错误");
		}
		if(user.getStatus()!=1){
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes(user.getUsername()) ,super.getName()); 
		return info;
	}


	/**
	 * 密码加密
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher  hash = new HashedCredentialsMatcher();
		hash.setHashAlgorithmName("MD5");//加密算法
		hash.setHashIterations(1024);//加密次数
		super.setCredentialsMatcher(hash);
	}
	
	

}
