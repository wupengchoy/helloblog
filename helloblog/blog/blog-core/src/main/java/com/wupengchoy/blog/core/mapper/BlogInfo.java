package com.wupengchoy.blog.core.mapper;

import com.wupengchoy.blog.facade.po.BlogInfoPO;

/**
 * Created by Jeremy on 11/21/18.
 */
//@Component
//@Qualifier("sqlSessionFactory")
public interface BlogInfo {
    BlogInfoPO getBlogs();
}
