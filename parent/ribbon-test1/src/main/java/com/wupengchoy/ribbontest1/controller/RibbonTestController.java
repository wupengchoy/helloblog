package com.wupengchoy.ribbontest1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbon")
public class RibbonTestController {

    @PostMapping("/test")
    public String testRibbon()
    {
        return "ribbon-test1";
    }
}
