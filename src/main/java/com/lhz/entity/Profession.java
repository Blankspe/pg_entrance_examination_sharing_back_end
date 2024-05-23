package com.lhz.entity;


import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Profession)表实体类
 *
 * @author makejava
 * @since 2024-05-23 07:38:03
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("profession")
@Builder
public class Profession  {
@TableId(value = "profession_id",type = IdType.AUTO)
    private Integer professionId;

//年份
    private Integer year;
//学校链接
    private String schoolLink;
//学校名称
    private String schoolName;
//院校链接
    private String yuanLink;
//院校名称
    private String yuanName;
//专业代码
    private Integer professionCode;
//专业链接
    private String professionLink;
//专业名称
    private String professionName;
//总分
    private Integer totalScore;
//政治分数
    private Integer politicalScore;
//外语分数
    private Integer foreLangScore;
//专业课一
    private Integer professionScoreOne;
//专业课二
    private Integer professionScoreTwo;



}

