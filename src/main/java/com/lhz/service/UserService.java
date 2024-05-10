package com.lhz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserLoginReqDTO;
import com.lhz.entity.dto.UserUpdateDTO;
import com.lhz.entity.vo.LoginRespVo;
import com.lhz.entity.vo.UserVO;


/**
 * 用户信息表(User)表服务接口
 *
 * @author makejava
 * @since 2024-03-25 15:55:51
 */
public interface UserService extends IService<User> {

    LoginRespVo login(UserLoginReqDTO user);

    Boolean updateUserInfo(UserVO userVO);

    UserVO getUserInfo(String userId);

    User getUserByPostId(Integer postId);
}

