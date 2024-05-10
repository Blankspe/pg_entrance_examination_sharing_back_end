package com.lhz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhz.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-01 12:42:51
 */
public interface CommentMapper extends BaseMapper<Comment> {

    void addPostComment(@Param("postID") String postID,@Param("commentID") Integer commentID);

    List<Comment> getCommentsByPostId(String postId);
}

