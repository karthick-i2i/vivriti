package com.vivriti.demo;

import com.vivriti.demo.config.RedisConfig;
import com.vivriti.demo.service.GroceryStoreMain;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class GroceryStoreInit {

    public static void main(String[] args) {
        GroceryStoreMain groceryStoreMain = new GroceryStoreMain();
        groceryStoreMain.groceryStoreMain(initRedisServer());
    }

    private static ValueOperations initRedisServer() {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(
                RedisConfig.class);
        try {
            RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
            ValueOperations values = redisTemplate.opsForValue();
            return values;
        } finally {
            ctx.close();
        }
    }

}
