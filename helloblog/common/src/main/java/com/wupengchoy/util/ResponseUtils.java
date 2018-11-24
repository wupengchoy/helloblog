package com.wupengchoy.util;

import com.wupengchoy.enumeration.ResponseEnum;
import com.wupengchoy.response.ResponseDTO;

/**
 * 返回给前端数据包装工具
 * Created by Jeremy on 11/22/18.
 */
public class ResponseUtils {

    public static ResponseDTO toSuccess(Object data) {
        ResponseDTO<Object> response = new ResponseDTO<Object>();

        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(data);

        return response;
    }

    public static ResponseDTO toFailure(ResponseEnum responseEnum, String data) {
        ResponseDTO<Object> response = new ResponseDTO<Object>();

        response.setCode(responseEnum.getCode());
        response.setMessage(responseEnum.getMessage());
        response.setData(data);

        return response;
    }
}
