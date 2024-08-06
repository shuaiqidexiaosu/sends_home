package com.sjy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 是否存在键为key的某条数据
     *
     * @param key 键值名称
     * @return true表示存在，false表示不存在
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 普通缓存获取
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        if (key == null || !redisTemplate.hasKey(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置永久有效的缓存
     *
     * @param key   键值名称
     * @param value 键值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置带时间的缓存
     *
     * @param key    键值名称
     * @param value  键值
     * @param offset 失效时间 要大于0 如果time小于等于0 将设置无限期
     */
    public void set(String key, Object value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * 删除键为key的数据
     *
     * @param key 键值名称
     */
    public void remove(String key) {
        if (key != null && redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
    }


}

