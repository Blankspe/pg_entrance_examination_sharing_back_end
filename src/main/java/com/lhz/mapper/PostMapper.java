package com.lhz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhz.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * (Posts)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-01 11:39:31
 */
public interface PostMapper extends BaseMapper<Post> {

    void likePost(String postId);

    List<Post> vagueSearch(String vaguePost);

    List<Post> getPostsByCategoryId(Integer categoryId);

    List<Post> getPostsByUserId(Integer userId);

    boolean addUserPost(@Param("userId") Integer userId,@Param("postId") Integer postId);

    void unlike(String postId);
}

