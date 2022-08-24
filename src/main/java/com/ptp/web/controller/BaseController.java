package com.ptp.web.controller;

import com.ptp.Enum.StatusCodeEnum;
import com.ptp.mode.RestResponse;

public class BaseController {

    public RestResponse success() {

        return RestResponse.builder().code(StatusCodeEnum.SUCCESS.getCode())
                .msg(StatusCodeEnum.SUCCESS.getMsg())
                .build();
    }
    public RestResponse success(String msg){

        return RestResponse.builder().code(StatusCodeEnum.SUCCESS.getCode()).msg(msg)
                .build();
    }
    public RestResponse success(String msg, Object data){

        return RestResponse.builder().code(StatusCodeEnum.SUCCESS.getCode()).msg(msg)
                .data(data)
                .build();
    }
    public RestResponse success( Object data){

        return RestResponse.builder().code(StatusCodeEnum.SUCCESS.getCode()).msg(StatusCodeEnum.SUCCESS.getMsg())
                .data(data)
                .build();
    }
    public RestResponse execption(String fialMsg, Object data){
        return RestResponse.builder()
                .code("400")
                .msg(fialMsg)
                .data(data)
                .build();
    }

    public RestResponse execption(){
        return RestResponse.builder()
                .code(StatusCodeEnum.EXCEPTION.getCode())
                .msg(StatusCodeEnum.EXCEPTION.getMsg())
                .build();
    }

    public RestResponse fail(String code, String fialMsg){
        return RestResponse.builder().code(code).msg(fialMsg).build();
    }
    public RestResponse fail(String fialMsg){
        return RestResponse.builder().code(StatusCodeEnum.FAILE.getCode()).msg(fialMsg).build();
    }
    public RestResponse fail(){
        return RestResponse.builder().code(StatusCodeEnum.FAILE.getCode()).msg(StatusCodeEnum.FAILE.getMsg()).build();
    }
}
