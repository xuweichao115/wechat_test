package com.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@Component
@EnableCaching
public class RedisEnableCaching {

    RedisEnableCaching(){
        System.out.println("已经加载");
    }
}
