package com.wupengchoy.util;

import com.wupengchoy.constant.ResponseEnum;
import com.wupengchoy.dto.ResponseDTO;

/**
 * Created by Jeremy on 11/15/18.
 */
public class ResponseUtil {
    public static ResponseDTO toSuccess(Object data) {
        ResponseDTO<Object> response = new ResponseDTO<>();
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static ResponseDTO toFailed(ResponseEnum responseEnum, Object data) {
        ResponseDTO<Object> response = new ResponseDTO<>();
        response.setMessage(responseEnum.getMessage());
        response.setCode(responseEnum.getCode());
        response.setData(data);
        return response;
    }
}
