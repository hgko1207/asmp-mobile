package com.ysc.after.school.mobile.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableCaching
@ComponentScan(basePackages = {"com.ysc.after.school.mobile.service"})
@Import(value = { JpaConfig.class })
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
