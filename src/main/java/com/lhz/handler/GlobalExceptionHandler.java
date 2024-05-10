package com.lhz.handler;

import com.lhz.exception.SystemException;
import com.lhz.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse<String> handleException(Exception e){
        log.info("系统异常",e);
        return BaseResponse.fail();
    }

    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public BaseResponse<String> handleSystemException(SystemException ex){
        log.info("系统异常处理",ex);
        return BaseResponse.fail(ex);
    }

}
