package com.hz.gc.security.basicfilter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
    登出的处理器,只需要做2件事情,移除redis缓存,清除authentication.
 */

@Component
public class LogOutHandler implements LogoutHandler {


    private RedisTemplate<String,Object> redisTemplate;

    public LogOutHandler(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public static final String FILE_NAME = "permission:";

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response,
                       Authentication authentication) {
        // 登出进入到当前处理器,判断请求头是否有token,有则移除.
        String token = request.getHeader("token");
        if(StringUtils.isNotBlank(token)){

            redisTemplate.delete(FILE_NAME+token);
            SecurityContextHolder.clearContext();
        }

    }
}
