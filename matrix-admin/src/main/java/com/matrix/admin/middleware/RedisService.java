package com.matrix.admin.middleware;

import cn.dev33.satoken.dao.SaTokenDao;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * redis 中间件
 * Redis 工具类
 * @author liuweizhong
 * @since 2025-03-17 00:26
 */
@Slf4j
@Component
public class RedisService {
    @Resource
    private SaTokenDao saTokenDao;


    /**
     * 存储字符串数据
     * @param key key
     * @param value 存储的字符串数据
     * @param time 过期时间（单位：秒）
     */
    public void saveData(String key, String value, long time) {
        saTokenDao.set(key, value, time);
    }

    /**
     * 存储对象（自动序列化为 JSON）
     * @param key key
     * @param obj 对象
     * @param time 过期时间（单位：秒）
     */
    public void saveObject(String key, Object obj, long time) {
        saTokenDao.setObject(key, obj, time);
    }

    /**
     * 删除指定 Key 的缓存数据
     * @param key key
     */
    public void delete(String key) {
        saTokenDao.delete(key);
    }

    /**
     * 获取指定 Key 的缓存数据
     * @param key key
     * @return 缓存数据
     */
    public String getData(String key) {
        return saTokenDao.get(key);
    }

    /**
     * 获取指定 Key 的缓存对象
     * @param key key
     * @return 缓存对象 无返回空
     */
    public Object getObject(String key) {
        return saTokenDao.getObject(key);
    }



}
