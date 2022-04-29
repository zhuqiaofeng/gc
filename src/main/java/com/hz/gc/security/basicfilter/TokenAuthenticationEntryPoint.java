/*
package com.hz.gc.security.basicfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.gc.common.CommonResult;
import com.hz.gc.common.ResponseState;
import com.hz.gc.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


*/
/**
 *  自定义无凭证处理类,未授权统一走这里
 *//*

@Slf4j
@Component
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.info("类名是:{},用户没有token凭证,进行拦截返回前端页面", TokenAuthenticationEntryPoint.class);

            // 返回前端告知
        ResponseUtil.out(response,CommonResult.error().code(ResponseState.NOT_LOGGED_IN).msg("无令牌登录"));


    }
}
*/
