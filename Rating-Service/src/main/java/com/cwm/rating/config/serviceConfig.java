package com.cwm.rating.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class serviceConfig {

	@Bean
	@LoadBalanced
	public RestTemplate returnRestTemplate() {
		return new RestTemplate();
	}
}
