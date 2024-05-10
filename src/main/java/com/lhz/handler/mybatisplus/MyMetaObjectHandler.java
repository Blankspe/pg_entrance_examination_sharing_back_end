package com.lhz.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = 1L;
        try {
//            userId = SecurityUtils.getUserId();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;//表示是自己创建
        }

        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
//        this.setFieldValByName("createBy",userId , metaObject);
//        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = 1L;
        try {
//            userId = SecurityUtils.getUserId();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -2L;//表示由系统自动更新

        }

        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", userId, metaObject);
    }
}