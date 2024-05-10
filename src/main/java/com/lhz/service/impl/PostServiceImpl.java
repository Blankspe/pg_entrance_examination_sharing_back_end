package com.lhz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.entity.Post;
import com.lhz.entity.User;
import com.lhz.entity.dto.PostAddDTO;
import com.lhz.entity.dto.PostDTO;
import com.lhz.mapper.PostMapper;
import com.lhz.service.PostService;
import com.lhz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * (Posts)表服务实现类
 *
 * @author makejava
 * @since 2024-04-01 11:39:31
 */
@Service("postsService")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private UserService userService;

    @Override
    public List<PostDTO> getPosts() {
        List<Post> postList = list();

        if (CollectionUtils.isEmpty(postList)){
            return Collections.EMPTY_LIST;
        }

        List<PostDTO> postDTOS = postsToPostDTOs(postList);

        return postDTOS;
    }

    @Override
    public Boolean addPost(PostAddDTO postDTO) {
        Post postDO = new Post();
        BeanUtils.copyProperties(postDTO,postDO);
        boolean isSuccessPost = save(postDO);
        Integer postId = postDO.getPostId();
        Integer userId = postDTO.getUserId();
        boolean isSuccessUserPost = baseMapper.addUserPost(userId,postId);

        return isSuccessPost&&isSuccessUserPost;
    }

    @Override
    public Boolean likePost(String postId) {
        baseMapper.likePost(postId);
        return true;
    }

    @Override
    public List<PostDTO> postSearch(String vaguePost) {
        List<Post> postList = baseMapper.vagueSearch(vaguePost);

        if (CollectionUtils.isEmpty(postList)){
            return Collections.EMPTY_LIST;
        }

        List<PostDTO> postDTOS = postsToPostDTOs(postList);

        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostsByCategoryId(Integer categoryId) {
        List<Post> postList = baseMapper.getPostsByCategoryId(categoryId);
        if (CollectionUtils.isEmpty(postList)){
            return Collections.EMPTY_LIST;
        }

        List<PostDTO> postDTOS = postsToPostDTOs(postList);

        return postDTOS;
    }

    private List<PostDTO> postsToPostDTOs(List<Post> postList) {
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post: postList){
            User user = userService.getUserByPostId(post.getPostId());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(user,postDTO);
            BeanUtils.copyProperties(post,postDTO);
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostsByUserId(Integer userId) {
        List<Post> posts = baseMapper.getPostsByUserId(userId);
        List<PostDTO> postDTOS = postsToPostDTOs(posts);
        return postDTOS;
    }
}

