/*
package com.hz.gc.security.basicfilter;

import com.hz.gc.common.ResponseState;
import com.hz.gc.pojo.Permissions;
import com.hz.gc.security.entity.SecurityUser;

import com.hz.gc.service.PermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Slf4j
public class AccessDecisionProcessor implements AccessDecisionVoter<FilterInvocation> {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private PermissionsService permissionsService;

    @Override
    public int vote(Authentication authentication, FilterInvocation object,
                    Collection<ConfigAttribute> attributes) {
            log.info("AccessDecisionManager将请求委托给我们自定义的投票器:{}...",AccessDecisionProcessor.class);

           // if(attributes != null && object!= null){

                String url = object.getRequestUrl();
                String method = object.getRequest().getMethod();
                log.info("自定义投票器*****--->,URI:{},{}",method,url);
                // 解决get请求带参数的问题
                if ("GET".equals(method)) {
                // 如果当前请求包含?
                  if(url.contains("?")){
                      // 则取出当前?在当前字符串中第一次出现出的索引
                      int index = url.indexOf("?");
                       // 把url进行截取,截取出从?开始到之前的字符串.
                        url = url.substring(0, index);
                      log.info("*******************"+url);

                  }
                }
                */
/*
                    数据库当中存储的是受保护的接口路径(每一个接口路径对应需要什么权限),如果能够根据当前用户访问的接口路径到数据库中查到
                    则说明此接口收到保护,如果查不到则说明此接口未收到保护,则弃票.
                    TODO 后续优化在服务器启动后直接把所有权限路径放到redis缓存,然后去缓存查
                 *//*

        List<Permissions> permissionList = (List<Permissions>)redisTemplate.opsForValue().get(ResponseState.PERMISSION_LIST);
        System.out.println("permissionList = " + permissionList);

        Permissions permission = null;

        for (Permissions authority : permissionList) {

            if(url.equals(authority.getPermUrl())){
                permission = new Permissions();
                BeanUtils.copyProperties(authority,permission);
            }
        }

               if(permissionList == null){
                   System.out.println(permissionList);
                   return ACCESS_ABSTAIN;  // 0为弃票 1为赞成 -1为反对
               }
                 */
/*
                    查询到当前请求路径所对应的接口的权限之后,只需要和用户带有的权限做比对即可,若用户的权限包含此请求对应的权限,则视为赞成
                    我们需要通过此对象中的权限和数据库表中此对象所拥有的权限做对比
                    假设此对象的权限是sys:list,sys:delete 而用户请求的是/user/add接口所对应的权限是sys:add,则不可访问
                 *//*

                // 通过当前authentication对象拿到封装的用户主体,用户在登录时如果认证通过则权限已经赋值到当前对象中了
                SecurityUser principal = (SecurityUser)authentication.getPrincipal();
                List<String> permissions = principal.getPermissions();
                if(permissions.contains(permission.getPermValue())){
                    log.info("用户具备访问此接口的权限...");
                    // 如果此用户的权限集合中包含此权限,则投赞成
                    return ACCESS_GRANTED;
                }else{
                    log.info("用户不具备访问此接口的权限,访问接口路径是:{},所需要的权限是:{} ,用户所具有的权限是:{}",
                            permission.getPermUrl(),permission.getPermValue(),permissions.toArray());
                    return ACCESS_DENIED;
                }
            //}

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


}
*/
