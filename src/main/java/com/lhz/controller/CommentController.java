package com.lhz.controller;

import com.lhz.entity.Comment;
import com.lhz.entity.dto.CommentAddDTO;
import com.lhz.entity.dto.CommentDTO;
import com.lhz.response.BaseResponse;
import com.lhz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public BaseResponse<Boolean> addComment(@RequestBody CommentAddDTO commentAddDTO){
        return BaseResponse.success(commentService.addComment(commentAddDTO));
    }
    @PostMapping("/getComments")
    public BaseResponse<List<CommentDTO>> getComments(String postId){
        return BaseResponse.success(commentService.getComments(postId));
    }

}
