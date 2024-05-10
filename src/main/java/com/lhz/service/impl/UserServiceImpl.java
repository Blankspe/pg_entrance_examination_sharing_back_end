package com.lhz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhz.constants.SystemConstants;
import com.lhz.entity.User;
import com.lhz.entity.dto.UserLoginReqDTO;
import com.lhz.entity.dto.UserUpdateDTO;
import com.lhz.entity.vo.LoginRespVo;
import com.lhz.entity.vo.UserVO;
import com.lhz.exception.SystemException;
import com.lhz.mapper.UserMapper;
import com.lhz.response.BaseResponse;
import com.lhz.service.UserService;
import com.lhz.utils.JwtUtil;
import com.lhz.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author makejava
 * @since 2024-03-25 15:55:51
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public LoginRespVo login(UserLoginReqDTO user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>();
        wrapper.eq(User::getPhone,user.getPhone());
        User userDO = getOne(wrapper);
        if (Objects.isNull(userDO)){
            throw new SystemException(401,"用户未注册");
        }
        if(!userDO.getPassword().equals(user.getPassword())){
            throw new SystemException(402,"账号或登录密码错误");
        }
        //生成jwt
        String userId = String.valueOf(userDO.getUserId());
        String jwt = JwtUtil.createJWT(userId);

        //将返回对象信息存入redis，减轻数据库压力
        String redisId = SystemConstants.LOGIN_TOKEN_KEY +userId;
        redisUtil.setCacheObject(redisId,userDO);
        //封装LoginRespVo
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setUserInfo(userDO);
        loginRespVo.setToken(jwt);

        return loginRespVo;
    }

    @Override
    public Boolean updateUserInfo(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        boolean isSuccess = updateById(user);
//        baseMapper.updateByUserUpdateDTO(userUpdateDTO);
        return isSuccess;
    }

    @Override
    public UserVO getUserInfo(String userId) {
        User user = getById(userId);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }

    @Override
    public User getUserByPostId(Integer postId) {
        return baseMapper.getUserByPostId(postId);

    }
}

