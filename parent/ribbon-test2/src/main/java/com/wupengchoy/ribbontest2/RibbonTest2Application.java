package com.wupengchoy.ribbontest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonTest2Application.class, args);
    }

}
