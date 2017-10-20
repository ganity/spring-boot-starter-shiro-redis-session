package com.github.ganity.shiro.redis;

import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisShiroConfiguration {

	@Bean
	@DependsOn(value = { "jedisShiroSessionRepository" })
	public SessionDAO sessionDAO(JedisShiroSessionRepository jedisShiroSessionRepository) {
		final RedisShiroSessionDAO customShiroSessionDAO = new RedisShiroSessionDAO();
		customShiroSessionDAO.setShiroSessionRepository(jedisShiroSessionRepository);
		return customShiroSessionDAO;
	}

	@Bean
	@DependsOn(value = { "objectRedisTemplate" })
	public JedisShiroSessionRepository jedisShiroSessionRepository(RedisTemplate<String, Object> objectRedisTemplate) {
		final JedisShiroSessionRepository jedisShiroSessionRepository = new JedisShiroSessionRepository();
		jedisShiroSessionRepository.setObjectRedisTemplate(objectRedisTemplate);
		return jedisShiroSessionRepository;
	}

	@Bean
	public RedisTemplate<String, Object> objectRedisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}

}