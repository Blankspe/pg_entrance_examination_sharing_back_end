package com.lhz.entity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Integer userId;

    private String userName;

    private String profilePict;

    private String phone;

    private String school;

    private String profession;

    private String type;

    private String sex;

    private String targetSchool;

    private Integer allScore;

    private Integer politicalScore;

    private Integer mathScore;

    private Integer englishScore;

    private Integer professionalCourseScore;

    private Integer realScore;
}
