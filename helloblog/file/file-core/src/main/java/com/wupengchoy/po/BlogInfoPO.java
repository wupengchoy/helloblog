package com.wupengchoy.po;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by Jeremy on 11/15/18.
 */
@Data
@Component
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
