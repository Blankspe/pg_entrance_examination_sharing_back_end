package com.lhz.controller;

import com.lhz.constants.SystemConstants;
import com.lhz.context.CurrentContext;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserLoginReqDTO;
import com.lhz.entity.vo.LoginRespVo;
import com.lhz.enums.HttpResponseEnum;
import com.lhz.exception.SystemException;
import com.lhz.response.BaseResponse;
import com.lhz.service.UserService;
import com.lhz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public BaseResponse<LoginRespVo> login(@RequestBody UserLoginReqDTO user){
        LoginRespVo loginUser = userService.login(user);
        if(Objects.isNull(loginUser)){
            throw new SystemException(HttpResponseEnum.LOGIN_FAILED);
        }
        return BaseResponse.success(loginUser);
    }

    @PostMapping("/logout")
    public BaseResponse logout(){
        Integer userId = CurrentContext.getUserId();
        String tokenKey = SystemConstants.LOGIN_TOKEN_KEY+userId;
        boolean isSuccess = redisUtil.deleteObject(tokenKey);
        return BaseResponse.success(isSuccess);
    }
}
