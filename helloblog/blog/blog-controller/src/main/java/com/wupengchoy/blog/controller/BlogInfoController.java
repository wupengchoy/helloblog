package com.wupengchoy.blog.controller;

import com.wupengchoy.blog.facade.po.BlogInfoPO;
import com.wupengchoy.blog.facade.service.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jeremy on 11/20/18.
 */
@RestController
public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;

    @RequestMapping(value = "bloginfoo", method = RequestMethod.POST)
    public BlogInfoPO getBlogInfo() {
        return blogInfoService.getBlogInfo();
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String getTest() {
        return "test <<< from controller";
    }
}
