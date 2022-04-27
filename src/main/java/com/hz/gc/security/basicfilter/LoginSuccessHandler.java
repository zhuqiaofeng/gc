package com.hz.gc.security.basicfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.gc.common.CommonResult;
import com.hz.gc.security.entity.SecurityUser;
import com.hz.gc.utils.JwtUtils;
import com.hz.gc.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  登录成功处理器,当由abstractAuthenticationProcessingFilter发起的认证流程结束,登录成功后则会调用此接口.
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
   private RedisTemplate<String,Object> redisTemplate;



   public static final String FILE_NAME = "permission:";
   public static final Integer EXPIRE_TIME = 1000*60*60*24*4;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

            log.info("用户登录成功....onAuthenticationSuccess()方法被调用");
        response.setContentType("application/json;charset=utf-8");
            // 生成token
        SecurityUser user = (SecurityUser) authentication.getPrincipal();

            // 将用户的信息包含到有效载荷中
        String token = JwtUtils.getJwtToken(user.getUsername(), null);
        System.out.println("token = " + token);
            // 登录成功之后,把token,和对应的用户相关信息存入redis
        redisTemplate.opsForValue().set(FILE_NAME+token,user,EXPIRE_TIME, TimeUnit.MILLISECONDS);

            // 返回给前端页面的token
         ResponseUtil.out(response,CommonResult.ok().data("token",token));


    }
}
