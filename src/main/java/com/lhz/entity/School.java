package com.lhz.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (School)表实体类
 *
 * @author makejava
 * @since 2024-04-08 11:17:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("school")
public class School  {
    @TableId
    private Integer schoolId;

    //学校名
    private String schoolName;



}

