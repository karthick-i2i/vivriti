package com.vivriti.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis config class to handle storage for
 * each transactions in grocery store
 */

@Configuration
public class RedisConfig {
    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }
}
