package com.lhz.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Comment)表实体类
 *
 * @author makejava
 * @since 2024-04-01 12:42:51
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class Comment  {
    //评论id，主键@TableId
    @TableId(value = "comment_id",type = IdType.AUTO)
    private Integer commentId;

    private Integer postId;

    //评论内容
    private String content;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //发布评论的用户id
    private Integer userId;
    //评论的用户的id
    private Integer toCommentUserId;
    //对应的根评论的id
    private Integer rootId;
}

