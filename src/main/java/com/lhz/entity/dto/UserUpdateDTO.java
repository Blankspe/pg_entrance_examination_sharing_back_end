package com.lhz.entity.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateDTO {
    private Integer userId;
    private String userName;
    private String phone;
    private String school;
    private String profilePict;
}
