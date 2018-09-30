package com.redis;

import com.utility.SerializeUtil;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil{

    private Logger logger = Logger.getLogger(RedisUtil.class);
    private RedisTemplate<Serializable, Object> redisTemplate;

    private static JedisPool jedisPool;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置List集合
     * @param key
     * @param list
     */
    public void setList(String key , List<?> list){
        Jedis jedis = jedisPool.getResource();
        try {
            if(list == null || list.size() == 0){
                jedis.set(key.getBytes(), "".getBytes());
            }else{//如果list为空,则设置一个空
                jedis.set(key.getBytes(), SerializeUtil.serializeList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取List集合
     * @param key
     * @return
     */
    public List<?> getList(String key){
        Jedis jedis = jedisPool.getResource();
        if(jedis == null || !jedis.exists(key)){
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        return SerializeUtil.unserializeList(data);
    }

    public void setRedisTemplate(
            RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void setJedisConnectionFactory(JedisConnectionFactory  connectionFactory) {
        this.jedisPool = new JedisPool(connectionFactory.getHostName());
    }
}

