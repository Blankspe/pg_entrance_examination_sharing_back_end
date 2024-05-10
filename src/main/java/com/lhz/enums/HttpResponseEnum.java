package com.lhz.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum HttpResponseEnum {

    NO_REGISTER(401,"用户未注册"),
    TOKEN_EXPIRE(403,"token已失效"),
    WRONG_SECRET(402,"账号或密码错误"),
    WRONG_TOKEN(404,"token错误" ),
    NO_LOGIN(405, "用户未登录"),
    LOGIN_FAILED(406,"登录失败" );

    private int code;
    private String msg;


}
