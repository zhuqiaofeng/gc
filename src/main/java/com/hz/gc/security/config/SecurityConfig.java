package com.hz.gc.security.config;

import com.hz.gc.security.basicfilter.*;
import io.swagger.models.HttpMethod;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

/*
      Security的核心配置类,用与验证用户,鉴权..
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetailService;
    @Autowired
    private DefaultPasswordEncoder defaultPasswordEncoder;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LogOutHandler logOutHandler;
    @Autowired
    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;
    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Autowired
    @Lazy
    private JwtTokenAuthenticationLoginFilter jwtTokenAuthenticationLoginFilter;

    /* private JwtTokenAuthenticationLoginFilter jwtTokenAuthenticationLoginFilter
               = new JwtTokenAuthenticationLoginFilter(redisTemplate);*/
    /*
    认证用户 用户名密码是否正确
 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(defaultPasswordEncoder);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行所需要用到的静态资源，允许访问 swagger相关
     /*   web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-resources/configuration/ui",
                "/*.html", "/css/**","/img/**","/js/**","/*.ico"
                );*/
        web.ignoring().antMatchers(
                "/**/*.js",
                "/lang/*.json",
                "/**/*.css",
                "/**/*.js",
                "/**/*.map",
                "/**/*.html",
                "/**/*.png",
                "/swagger**/**",
                "/webjars/**",
                "/v2/**",
                "*.html",
                "/sa-frame/**",
                "/sa-view/**",
                "/static/**"

        );
    }

    /*
        自定义的投票器,让AccessDecisionManager使用我们的投票器.
     */
    @Bean
    public AccessDecisionVoter<FilterInvocation> AccessDecisionProcessor(){

        return new AccessDecisionProcessor();
    }

    /*
        构建一个新的AccessDecisionManager,更改投票策略以及将我们构建的自定义投票器放进去.
     */
    @Bean
    public AccessDecisionManager accessDecisionManager(){

        List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
        /*
            第一个投票器,用于根据配置类中的配置进行逻辑处理得出结果
         */
        decisionVoters.add(new WebExpressionVoter());
        /*
            第二个投票器是我们自定义的,让AccessDecisionManager的实现类也将请求委托给我们,我们来做鉴权
         */
        decisionVoters.add(AccessDecisionProcessor());

         return new UnanimousBased(decisionVoters);
    }

    /*
        用户授权
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.csrf().disable();
        // 打开Spring Security的跨域
        http.cors();
        // 配置自定义的类.
        http
                .authorizeRequests()
                // 对于登录login
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                // 使用我们自定义的AccessDecisionManager
                .accessDecisionManager(accessDecisionManager())
                .and()
                // 登录配置,登录成功和登录失败处理器是哪一个
                .formLogin()
                .loginProcessingUrl("/login") // 登录表单使用的路径action
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                // 表明登出处理器是哪一个
                .logout()
                .addLogoutHandler(logOutHandler)
                .logoutUrl("/logout") // 登出表单使用的路径 action
                // 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 自定义的异常处理类,未登录与权限不足处理器.
                .exceptionHandling()
                 .authenticationEntryPoint(tokenAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .addFilterBefore(jwtTokenAuthenticationLoginFilter,UsernamePasswordAuthenticationFilter.class)
                .httpBasic();
    }


    /*
        通过security自带的身份验证管理器对象的authenticate()方法,security会自动认证.
     */


        @Bean
        public AuthenticationManager authenticationManager() throws Exception {

                return super.authenticationManager();
        }

}
