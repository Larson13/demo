package com.ptp.web.advice;

import com.ptp.Enum.StatusCodeEnum;
import com.ptp.mode.RestResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse methodArgumentNotValidException (HttpServletRequest request, MethodArgumentNotValidException e)   {
        e.printStackTrace();

        return RestResponse.builder()
                .code(StatusCodeEnum.EXCEPTION.getCode())
                .msg(getError(e.getBindingResult()))
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse defaultException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return RestResponse.builder()
                .code(StatusCodeEnum.EXCEPTION.getCode())
                .msg(StatusCodeEnum.EXCEPTION.getMsg())
                .build();
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public RestResponse bindException(HttpServletRequest request, BindException e) {
        e.printStackTrace();
        return RestResponse.builder()
                .code(StatusCodeEnum.EXCEPTION.getCode())
                .msg(getError(e.getBindingResult()))
                .build();
    }

    @ExceptionHandler(value = DemoException.class)
    @ResponseBody
    public RestResponse demoException(HttpServletRequest request, DemoException e) {
        e.printStackTrace();
        return RestResponse.builder()
                .code(StatusCodeEnum.EXCEPTION.getCode())
                .msg(e.getMsg())
                .build();
    }


    private String getError(BindingResult bindingResult)  {
        StringBuffer sb = new StringBuffer();
        if ( bindingResult.hasErrors() ) {
            for ( ObjectError error : bindingResult.getAllErrors()) {
                sb.append( error.getDefaultMessage()).append(",");
            }
        }
        String errMsg = sb.toString();
        errMsg = errMsg.substring(0, errMsg.lastIndexOf(","));

        return errMsg ;
}
}

