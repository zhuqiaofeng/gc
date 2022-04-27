package com.hz.gc.security.basicfilter;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.gc.security.entity.SecurityUser;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.List;

/*
    token过滤器,对于token进行认证的.
 */

@Slf4j
@Component
public class JwtTokenAuthenticationLoginFilter extends BasicAuthenticationFilter{

     @Autowired
     private RedisTemplate<String,Object> redisTemplate;
     @Autowired
    private UserDetailsService customUserDetailService;

    public static final String FILE_NAME = "permission:";

    public JwtTokenAuthenticationLoginFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    /*
            判断当前请求是否携带token.
         */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            log.info("进入了类名是,{} 开始处理... JWT token过滤器校验请求头是否包含token.....",JwtTokenAuthenticationLoginFilter.class);
        // 通过请求头获取token
        String token = request.getHeader("token");
        // token不未空则说明用户已经登录过, 去redis拿到权限
        if(StringUtils.isNotBlank(token)){
                    // 能拿到则说明此token没有问题,已经拿到对应的权限了
            SecurityUser user = (SecurityUser) redisTemplate.opsForValue().get(FILE_NAME+token);

            if(user != null  && SecurityContextHolder.getContext().getAuthentication() == null){
      // 能通过token获取到缓存中的用户说明token是正确的,但也有可能存在用户信息已经修改 缓存未改 需要通过数据库查询最新的用户信息
                UserDetails userDetails = customUserDetailService.loadUserByUsername(user.getUsername());

                if(userDetails != null){
                    // 开始创建userNamePasswordAuthenticationToken对象,封装信息,用于后面AuthenticationManager认证用.
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    // 构建request对象
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将其放入到SecurityContextHolder中,方便security使用
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    log.info("JWT过滤器通过校验请求头token自动登录成功, user : {}", user.getUsername());
                }
            }
        }
                chain.doFilter(request,response);

    }
}
