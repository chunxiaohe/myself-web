package com.sipingsoft.core.constants;

public interface Constants {

    String SHIRO_SESSION_KEY = "shiro_session:";
    
    String SHIRO_CACHE_KEY = "shiro_cache:";

    String SHIRO_WECHAT_SESSION_KEY = "shiro_whechat_session:"; // 微信网页授权，用户信息缓存

    String SHIRO_WECHAT_SESSION_CODE = "shiro_whechat_session_code:"; // 微信网页授权 code缓存

    //加密次数
    int SHIRO_SALT_HASH_ITERATIONS = 16;

    // 加密方式
    String SHIRO_ALGORITHM_NAME = "SHA-256";
    
}
