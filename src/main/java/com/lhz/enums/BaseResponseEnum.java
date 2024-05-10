package com.lhz.enums;

import javafx.scene.input.KeyCodeCombination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseResponseEnum {

    SUCCESS(200,"请求成功"),
    FAILED(401,"登录失败");

    private int code;
    private String msg;

}
