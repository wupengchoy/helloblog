package com.wupengchoy.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的包装类型
 * Created by Jeremy on 11/22/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;
}
