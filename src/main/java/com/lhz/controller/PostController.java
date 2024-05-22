package com.lhz.controller;

import com.lhz.entity.Post;
import com.lhz.entity.dto.PostAddDTO;
import com.lhz.entity.dto.PostDTO;
import com.lhz.response.BaseResponse;
import com.lhz.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.NetworkInterface;
import java.util.List;

@RestController
@RequestMapping
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getPosts")
    public BaseResponse<List<PostDTO>> getPosts(){
        return BaseResponse.success(postService.getPosts());
    }

    @PostMapping("/getPostsByCategory")
    public BaseResponse<List<PostDTO>> getPostsByCategoryId(Integer categoryId){
        return BaseResponse.success(postService.getPostsByCategoryId(categoryId));
    }

    @PostMapping("/getPostsByUserId")
    public BaseResponse<List<PostDTO>> getPostsByUserId(Integer userId){
        return BaseResponse.success(postService.getPostsByUserId(userId));
    }

    /**
     * 用户发送帖子
     * @param postDTO
     * @return
     */
    @PostMapping("/addPost")
    public BaseResponse<Boolean> addPost(@RequestBody Post postDTO){
        return BaseResponse.success(postService.addPost(postDTO));
    }

    @PostMapping("/like")
    public BaseResponse<Boolean> likePost(String postId,String type){
        return BaseResponse.success(postService.likePost(postId,type));
    }

}
