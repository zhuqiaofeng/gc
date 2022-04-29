/*
package com.hz.gc.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.gc.common.ResponseState;
import com.hz.gc.common.SomsConstants;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.Permissions;
import com.hz.gc.pojo.Role;
import com.hz.gc.pojo.User;
import com.hz.gc.pojo.UserRoleRelation;
import com.hz.gc.security.entity.SecurityUser;
import com.hz.gc.service.PermissionsService;
import com.hz.gc.service.RoleService;
import com.hz.gc.service.UserRoleRelationService;
import com.hz.gc.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

*/
/*
    自定义的UserDetailService,通过自定义类去数据库通过用户名去查询用户相关信息,查询到之后,封装到自定义的SecurityUser中返回
    然后会进入AuthenticationManager.authenticate()来认证.
 *//*


@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleRelationService userRoleRelationService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionsService permissionsService;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        log.info("进入到了loadUserByUsername()方法........");
        if(!StringUtils.isNotBlank(username)){
            throw new GcException(ResponseState.SERVER_ERROR,"用户名为空");
        }
        // 查询用户
        System.out.println("****************"+username+"-------------->"+SomsConstants.UserConstants.USER_STATE_ENABLE.getCode());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",username);
        User userinfo = userService.getOne(wrapper);
        if(null == userinfo){
            log.error("数据库当中无此用户:{}",username);
            throw new UsernameNotFoundException("用户名不存在或用户已经被禁用,登录失败");
        }
        // 通过用户id查询到对应的角色id.
        Integer userId = userinfo.getUserId();
        List<UserRoleRelation> relations = userRoleRelationService.list(new QueryWrapper<UserRoleRelation>().eq("userId", userId));
        if(relations.size() <= 0){

            throw new GcException(ResponseState.SERVER_ERROR,"此用户无角色,请分配");
        }

        */
/*
                遍历用户角色关系表,获得角色id,封装到id集合,查出对应的所有角色.
         *//*

         List<Integer> roleIds = new ArrayList<>();

          relations.forEach(item ->{
              roleIds.add(item.getRoleId());
          });

          */
/*
                通过角色id获取到所有角色信息,方便后续使用;
                通过用户id获取到此用户所对应的所有权限,都封装到userDetails中,后续security封装到Authentication对象中.
           *//*

        List<Role> roleInfoList = roleService.getRoleListByIds(roleIds);
        List<String> permissionsList = permissionsService.getPermissionByUserId(userId);
        List<Permissions> permissions = permissionsService.getPermissionListByUserId(userId);
        SecurityUser user = new SecurityUser();
        user.setUsername(userinfo.getUserName());
        user.setPassword(userinfo.getUserPassword());
        user.setRoleInfo(roleInfoList);
        user.setPermissions(permissionsList);
        user.setPermissionList(permissions);


        return user;
    }
}
*/
