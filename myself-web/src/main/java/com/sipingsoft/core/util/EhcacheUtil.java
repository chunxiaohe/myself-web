package com.sipingsoft.core.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 缓存消息工具类
 *
 * @author HeChunXiao
 * @since 2018-10-30 上午 9:42
 */

public class EhcacheUtil {


    private EhCacheManager ehCacheManager;

    private CacheManager cacheManager;


    public static EhcacheUtil getInstance() {
        return new EhcacheUtil();
    }

    public EhcacheUtil() {
        //获取缓存管理器的bean
        this.ehCacheManager = (EhCacheManager) ApplicationContextUtil.getContext().getBean("ehCacheManager");
        this.cacheManager = this.ehCacheManager.getCacheManager();
    }

    /**
     * 获取缓存信息
     *
     * @param cacheName 缓存名字
     * @param key       缓存的key
     * @return
     */
    public Object getEhcacheInfo(String cacheName, String key) {
        Cache cache = this.cacheManager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    /**
     * 储存缓存信息
     *
     * @param cacheName
     * @param key
     * @param obj
     */
    public void putEhcacheInfo(String cacheName, String key, Object obj) {
        Cache cache = this.cacheManager.getCache(cacheName);
        Element element = new Element(key, obj);
        cache.put(element);
    }

    /***
     * 清除缓存信息
     * @param cacheName
     * @param key
     */
    public void clearEchcacheInfo(String cacheName, String key) {
        Cache cache = this.cacheManager.getCache(cacheName);
        cache.remove(key);
    }

}
