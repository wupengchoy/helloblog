package com.wupengchoy.mystudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class MystudyApplication {
    @Bean
    @LoadBalanced //配置负载均衡
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(MystudyApplication.class, args);
    }

}

