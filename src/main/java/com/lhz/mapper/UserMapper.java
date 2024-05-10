package com.lhz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserUpdateDTO;


/**
 * 用户信息表(User)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-25 15:55:51
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserByPostId(Integer postId);

    void updateByUserUpdateDTO(UserUpdateDTO userUpdateDTO);
}

