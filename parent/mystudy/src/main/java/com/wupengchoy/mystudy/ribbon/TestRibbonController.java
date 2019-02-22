package com.wupengchoy.mystudy.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/study")
public class TestRibbonController {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/ribbon/test")
    public String testRibbon() {
        System.out.println(222);
        String result = null;
        try {
            System.out.println(this.restTemplate.getForObject("http://localhost:8180y/ribbon/test", String.class));
//            result = this.restTemplate.getForObject("http://ribbon-test:8180/ribbon/test", String.class);
        } catch (Exception e) {
            System.out.println("出异常啦！" + e.getMessage());
            return null;
        }
        System.out.println("成功啦");
        return result;
    }

    @PostMapping("/get")
    public int getInt() {
        return 4;
    }
}
