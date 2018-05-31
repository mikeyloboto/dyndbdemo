package com.evilbas.dyndbdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evilbas.dyndbcache.DynCache;

@Configuration
public class Config {
	
	@Bean
	DynCache dynCache() {
		return new DynCache();
	}
}
