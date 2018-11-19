package com.wupengchoy.service.imple;

import com.wupengchoy.bean.dto.BlogInfoDTO;
import com.wupengchoy.mapper.BlogInfo;
import com.wupengchoy.po.BlogInfoPO;
import com.wupengchoy.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jeremy on 11/15/18.
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogInfo blogInfo;

    @Override
    public BlogInfoDTO getBlogInfo() {
        BlogInfoPO blogInfoPO= blogInfo.getBlogInfo();
        BlogInfoDTO dto = new BlogInfoDTO();
        dto.setAuthorID(blogInfoPO.getAuthorID());
        dto.setBlogID(blogInfoPO.getBlogID());
        dto.setContent(blogInfoPO.getContent());
        dto.setLikeCount(blogInfoPO.getLikeCount());
        dto.setNickName(blogInfoPO.getNickName());
        dto.setReleaseTime(blogInfoPO.getReleaseTime());
        dto.setTitle(blogInfoPO.getTitle());
        dto.setViewCount(blogInfoPO.getViewCount());

        return dto;
    }
}
