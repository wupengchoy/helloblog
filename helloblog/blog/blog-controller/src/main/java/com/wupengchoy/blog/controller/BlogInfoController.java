package com.wupengchoy.blog.controller;

import com.wupengchoy.blog.facade.po.BlogInfoPO;
import com.wupengchoy.blog.facade.service.BlogInfoService;
import com.wupengchoy.response.ResponseDTO;
import com.wupengchoy.util.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jeremy on 11/20/18.
 */
@RestController
@Api("blog接口信息")
public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;

    @RequestMapping(value = "bloginfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询blog信息", notes = "查询博客信息")
    public ResponseDTO<BlogInfoPO> getBlogInfo() {
        return ResponseUtils.toSuccess(blogInfoService.getBlogInfo());
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public ResponseDTO<String> getTest() {
        return ResponseUtils.toSuccess("test <<< from controller");
    }
}
