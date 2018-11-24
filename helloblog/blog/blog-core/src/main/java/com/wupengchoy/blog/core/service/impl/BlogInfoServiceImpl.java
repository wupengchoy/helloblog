package com.wupengchoy.blog.core.service.impl;

import com.wupengchoy.blog.core.mapper.BlogInfoMapper;
import com.wupengchoy.blog.facade.po.BlogInfoPO;
import com.wupengchoy.blog.facade.service.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jeremy on 11/20/18.
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    private BlogInfoMapper blogInfo;
    @Override
    public BlogInfoPO getBlogInfo() {
        return blogInfo.getBlogs();
    }
}
