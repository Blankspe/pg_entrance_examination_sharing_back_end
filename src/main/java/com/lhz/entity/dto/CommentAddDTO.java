package com.lhz.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.lhz.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentAddDTO {
    private String postId;
    private Integer commentId;

    //评论内容
    private String content;
    private LocalDateTime createTime;
    //发布评论的用户id
    private Integer userId;
    //评论的用户的id
    private Integer toCommentUserId;
    //对应的根评论的id
    private Integer rootId;
}
