package com.srs.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

public abstract class BaseRedisProducer {
    private final RedisTemplate<String, Object> redisTemplate;

    protected BaseRedisProducer(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
