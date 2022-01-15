package com.example.springbootlearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringbootlearnApplication.class)
public class SpringbootlearnApplicationTests {

	@Resource
	private StringRedisTemplate stringRedisTemplate;
//	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		stringRedisTemplate.opsForValue().set("demo1","demovalue");
		String demo1 = stringRedisTemplate.opsForValue().get("demo1");
		System.out.println(demo1);
	}


}
