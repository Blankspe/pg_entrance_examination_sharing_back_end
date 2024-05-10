package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.Comment;
import com.lhz.entity.dto.CommentAddDTO;
import com.lhz.entity.dto.CommentDTO;

import java.util.List;


/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 12:42:51
 */
public interface CommentService extends IService<Comment> {

    Boolean addComment(CommentAddDTO commentAddDTO);

    List<CommentDTO> getComments(String postId);
}

