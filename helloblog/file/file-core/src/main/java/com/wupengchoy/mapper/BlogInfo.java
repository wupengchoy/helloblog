package com.wupengchoy.mapper;

import com.wupengchoy.po.BlogInfoPO;
import org.springframework.stereotype.Component;

/**
 * Created by Jeremy on 11/16/18.
 */
@Component(value = "blogInfo")
public interface BlogInfo {
    BlogInfoPO getBlogInfo();
}
