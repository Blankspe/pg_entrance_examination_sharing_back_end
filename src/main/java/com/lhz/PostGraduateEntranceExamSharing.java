package com.lhz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.lhz.mapper")
@ServletComponentScan(basePackages = "com.lhz.filter")
public class PostGraduateEntranceExamSharing {
    public static void main(String[] args) {
        SpringApplication.run(PostGraduateEntranceExamSharing.class,args);
    }
}
