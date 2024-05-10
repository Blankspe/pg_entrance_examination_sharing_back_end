package com.lhz.filter;

import com.alibaba.fastjson.JSON;
import com.lhz.constants.SystemConstants;
import com.lhz.context.CurrentContext;
import com.lhz.context.UserContext;
import com.lhz.entity.User;
import com.lhz.enums.HttpResponseEnum;
import com.lhz.exception.SystemException;
import com.lhz.utils.JwtUtil;
import com.lhz.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebFilter(urlPatterns = "/**")
//@Component
@Order(1)
public class GlobalAccessFilter implements Filter{

    @Autowired
    private RedisUtil redisUtil;

    List<String> whiteUrls = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteUrls.add("");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        System.out.println(httpServletRequest.getRequestURI());
        //1.获取token
        String token = httpServletRequest.getHeader("token");
        //1.1 未传入token
        if (!StringUtils.hasText(token)) {
            //没有token
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        //2.根据token 解析userId 解析失败情况
        String userId = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();

            throw new SystemException(HttpResponseEnum.TOKEN_EXPIRE);
        }
        //根据id从redis中获取用户信息 失败情况
        String redisId = SystemConstants.LOGIN_TOKEN_KEY + userId;
        if(Objects.isNull(userId)){
            //token错误，重新登录
            throw new SystemException(HttpResponseEnum.WRONG_TOKEN);
        }
        User loginUser = redisUtil.getCacheObject(redisId);
        if (Objects.isNull(loginUser)){
            throw new SystemException(HttpResponseEnum.NO_LOGIN);
        }

        //将用户信息存入上下文
        UserContext userContext = new UserContext();
        BeanUtils.copyProperties(loginUser,userContext);
        CurrentContext.setContext(userContext);

        //进入下一个过滤器
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

}
