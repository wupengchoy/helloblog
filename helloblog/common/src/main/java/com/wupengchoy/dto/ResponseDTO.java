package com.wupengchoy.dto;

import lombok.Data;

/**
 * Created by Jeremy on 11/14/18.
 */
@Data
public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;
}
