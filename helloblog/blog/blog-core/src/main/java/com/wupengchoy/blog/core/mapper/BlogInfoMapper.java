package com.wupengchoy.blog.core.mapper;

import com.wupengchoy.blog.facade.po.BlogInfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Jeremy on 11/21/18.
 */
@Component
@Mapper
public interface BlogInfoMapper {
    BlogInfoPO getBlogs();
}
