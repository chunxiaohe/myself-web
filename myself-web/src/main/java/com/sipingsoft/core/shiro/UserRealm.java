package com.sipingsoft.core.shiro;

import java.util.Set;

import com.sipingsoft.core.util.EhcacheUtil;
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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sipingsoft.web.sys.entity.SysUser;
import com.sipingsoft.web.sys.mapper.SysUserMapper;

/**
 *
 * @author He Chunxiao
 */
@Component
public class UserRealm extends AuthorizingRealm  {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ShiroRelamService shiroReamService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //缓存中获取权限
        Set<String> permissions = (Set<String>) EhcacheUtil.getInstance().getEhcacheInfo("authorizationCache", "permissions");
        if (permissions == null || permissions.size() == 0) {
            //无缓存
            SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
            permissions = shiroReamService.findPermissions(sysUser.getUserId().intValue());
            permissions.forEach(s -> System.out.println(s));
            //加入缓存
            EhcacheUtil.getInstance().putEhcacheInfo("authorizationCache","permissions",permissions);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        SysUser user = (SysUser) EhcacheUtil.getInstance().getEhcacheInfo("authenticationCache", "user");
        if (user == null) {
            UsernamePasswordToken token = (UsernamePasswordToken) authToken;
            //String pwd = new SimpleHash("MD5",token.getPassword(),token.getUsername(),1).toString();//密码加密
            SysUser sysUser = new SysUser();
            sysUser.setUsername(token.getUsername());
            user = sysUserMapper.selectOne(sysUser);
            if (user == null) {
                throw new UnknownAccountException();
            }
            if (user.getStatus() != 1) {
                //账号锁定
                throw new LockedAccountException();
            }
            //加入缓存
            EhcacheUtil.getInstance().putEhcacheInfo("authenticationCache", "user", user);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getUsername()), super.getName());
        return info;
    }


    /**
     * 密码加密
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hash = new HashedCredentialsMatcher();
        //加密算法
        hash.setHashAlgorithmName("MD5");
        //加密次数
        hash.setHashIterations(1024);
        super.setCredentialsMatcher(hash);
    }

}
