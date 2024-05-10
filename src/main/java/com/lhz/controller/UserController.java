package com.lhz.controller;

import com.lhz.entity.User;
import com.lhz.entity.dto.UserUpdateDTO;
import com.lhz.entity.vo.UserVO;
import com.lhz.response.BaseResponse;
import com.lhz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/update")
    public BaseResponse<Boolean> updateUserInfo(@RequestBody UserVO userVO){

        return BaseResponse.success(userService.updateUserInfo(userVO));
    }

    @PostMapping("/getUserInfo")
    public BaseResponse<UserVO> getUserInfo(String userId){
        return BaseResponse.success(userService.getUserInfo(userId));
    }

}
