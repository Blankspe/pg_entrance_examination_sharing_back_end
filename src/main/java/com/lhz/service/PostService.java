package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.Post;
import com.lhz.entity.dto.PostAddDTO;
import com.lhz.entity.dto.PostDTO;

import java.util.List;


/**
 * (Posts)表服务接口
 *
 * @author makejava
 * @since 2024-04-01 11:39:31
 */
public interface PostService extends IService<Post> {

    List<PostDTO> getPosts();

    Boolean addPost(Post postDTO);

    Boolean likePost(String postId,String type);

    List<PostDTO> postSearch(String vaguePost);

    List<PostDTO> getPostsByCategoryId(Integer categoryId);

    List<PostDTO> getPostsByUserId(Integer userId);
}

