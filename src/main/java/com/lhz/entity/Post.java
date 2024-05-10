package com.lhz.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Posts)表实体类
 *
 * @author makejava
 * @since 2024-04-01 11:39:31
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("post")
public class Post {
    @TableId
    private Integer postId;

    private String title;

    private String contents;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer likes;
}

