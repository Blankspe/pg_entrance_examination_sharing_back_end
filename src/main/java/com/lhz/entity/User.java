package com.lhz.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户信息表(User)表实体类
 *
 * @author makejava
 * @since 2024-03-25 10:38:29
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User  {
    @TableId
    private Integer userId;

    private String userName;

    private String phone;

    private String profilePict;

    private String password;
    
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

    public User(String userName){
        this.userName = userName;
    }
}

