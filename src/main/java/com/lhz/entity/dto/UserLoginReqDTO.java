package com.lhz.entity.dto;

import lombok.Data;

@Data
public class UserLoginReqDTO {
    private String phone;
    private String password;
}
