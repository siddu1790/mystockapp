package com.stock.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    /**
     * This is a Configuration class , created to return Rest Template. This method will also take care
     * of load balancing (spring boot knows to loadbalanced it)
     *
     * @return restTemplate
     */

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
