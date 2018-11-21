package com.wupengchoy.blog.facade.po;

import lombok.Data;

/**
 * Created by Jeremy on 11/21/18.
 */
@Data
public class BlogInfoPO {
    private int blogID;
    private String title;
    private String content;
    private String releaseTime;
    private int viewCount;
    private int likeCount;


    private int authorID;
    private String nickName;
}
