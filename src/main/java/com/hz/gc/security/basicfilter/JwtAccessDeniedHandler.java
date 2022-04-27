package com.hz.gc.security.basicfilter;

import com.hz.gc.common.CommonResult;
import com.hz.gc.common.ResponseState;
import com.hz.gc.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    无权限访问处理类
 */
@Component
@Slf4j
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        log.info("进入了{}无权限处理类,异常信息是:{},异常类是:{}",JwtAccessDeniedHandler.class,accessDeniedException.getMessage(),
                accessDeniedException.getClass());

        ResponseUtil.out(response, CommonResult.error().setCode(ResponseState.WITHOUT_PERMISSION).setMsg("无权限访问此资源"));

    }
}
