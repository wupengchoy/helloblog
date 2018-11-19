package com.wupengchoy.controller;

import com.wupengchoy.dto.ResponseDTO;
import com.wupengchoy.po.BlogInfoPO;
import com.wupengchoy.service.BlogService;
import com.wupengchoy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jeremy on 11/16/18.--test git
 */
@RestController
public class BlogInfoController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/bloginfo", method = RequestMethod.POST)
    public ResponseDTO<BlogInfoPO> getBlogInfo() {
        return ResponseUtil.toSuccess(blogService.getBlogInfo());
    }
}
