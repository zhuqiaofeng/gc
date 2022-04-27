package com.hz.gc.security.basicfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.gc.common.CommonResult;
import com.hz.gc.common.ResponseState;
import com.hz.gc.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  登录失败的接口,在由AbstractAuthenticationProcessing发起的认证流程中,AuthenticationManager来完成实际认证若
 *  若认证失败,则到此处理器
 */
@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.error("登录失败,异常信息是:{},异常类是:{}",exception.getMessage(),exception.getClass());

        ResponseUtil.out(response,CommonResult.error().setCode(ResponseState.SERVER_ERROR).setMsg("用户名密码错误"));
    }
}
