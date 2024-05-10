package com.lhz.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 标签枚举(Category)表实体类
 *
 * @author makejava
 * @since 2024-04-22 14:44:35
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("category")
public class Category  {
    @TableId
    private Integer tagId;

    //标签名称

    private String tagName;



}

