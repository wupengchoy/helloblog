package com.wupengchoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.wupengchoy.blog.core.mapper")
//@ComponentScan(basePackages = {"com.wupengchoy.blog.facade.po","com.wupengchoy"})
public class BlogControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogControllerApplication.class, args);
    }
}
