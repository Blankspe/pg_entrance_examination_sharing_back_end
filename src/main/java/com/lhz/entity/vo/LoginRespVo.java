package com.lhz.entity.vo;

import com.lhz.entity.User;
import lombok.Data;

@Data
public class LoginRespVo {
    private String token;
    private User userInfo;
}
