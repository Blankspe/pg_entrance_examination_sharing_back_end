package com.lhz.response;

import com.lhz.entity.User;
import com.lhz.enums.BaseResponseEnum;
import com.lhz.exception.SystemException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private Integer resultCode;
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 友好的中文提示
     */
    private String msg;

    public BaseResponse(Integer resultCode,T data){
        this.resultCode = resultCode;
        this.data = data;
    }
    public BaseResponse(Integer resultCode,String msg){
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public BaseResponse(Integer resultCode){
        this.resultCode = resultCode;
    }

    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse(BaseResponseEnum.SUCCESS.getCode(),data,"请求成功");
    }

    public static <T> BaseResponse<T> success(){
        return new BaseResponse(BaseResponseEnum.SUCCESS.getCode());
    }

    public static BaseResponse fail() {
        return new BaseResponse(BaseResponseEnum.FAILED.getCode(),"请求失败");
    }

    public static <T> BaseResponse<T> fail(SystemException ex) {
        return new BaseResponse(ex.getCode(),ex.getMsg());
    }
}
