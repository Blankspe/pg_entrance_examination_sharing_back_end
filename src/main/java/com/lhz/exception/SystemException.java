package com.lhz.exception;

import com.lhz.enums.HttpResponseEnum;
import lombok.Data;

@Data
public class SystemException extends RuntimeException{
    private String msg;
    private Integer code;
    public SystemException(Integer code,String msg){
        super(msg,null,true,true);
        this.code = code;
        this.msg = msg;
    }
    public SystemException(HttpResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

}
