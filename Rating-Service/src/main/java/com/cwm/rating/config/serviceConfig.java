package com.cwm.rating.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class serviceConfig {

	@Bean
	public RestTemplate returnRestTemplate() {
		return new RestTemplate();
	}
}
