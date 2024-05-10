package com.lhz.context;

import com.lhz.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContext {
    private Integer userId;

    private String userName;

    private String profilePict;

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
