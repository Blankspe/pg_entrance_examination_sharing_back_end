package com.lhz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Comment;
import com.lhz.entity.User;
import com.lhz.entity.dto.CommentAddDTO;
import com.lhz.entity.dto.CommentDTO;
import com.lhz.mapper.CommentMapper;
import com.lhz.service.CommentService;
import com.lhz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 12:42:51
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public Boolean addComment(CommentAddDTO commentAddDTO) {
        Comment comment = new Comment();

        BeanUtils.copyProperties(commentAddDTO,comment);

        save(comment);

        return true;
    }

    @Override
    public List<CommentDTO> getComments(String postId) {
        List<Comment> comments = baseMapper.getCommentsByPostId(postId);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.stream().forEach(e->{
            CommentDTO commentDTO = new CommentDTO();

            BeanUtils.copyProperties(e,commentDTO);

            User user = userService.getById(e.getUserId());
            BeanUtils.copyProperties(user,commentDTO);
            commentDTOS.add(commentDTO);
        });
        return commentDTOS;
    }
}

