package com.lhz.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PostLikeTypeEnum {
    LIKE("0","喜欢"),
    UNLIKE("1","取消喜欢");

    private String type;
    private String msg;
}
