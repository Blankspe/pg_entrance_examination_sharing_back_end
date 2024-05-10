package com.lhz.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 考研政策表(Policy)表实体类
 *
 * @author makejava
 * @since 2024-04-01 15:21:38
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("policy")
public class Policy  {
    //考研政策id@TableId
    private Integer policyId;

    //政策内容
    private String content;
    //政策类型（0代表不区分院校的政策，1代表区分院校的政策）
    private String type;

    private Integer schoolId;



}

