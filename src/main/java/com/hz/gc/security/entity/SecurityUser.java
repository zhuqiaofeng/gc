/*
package com.hz.gc.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hz.gc.pojo.Permissions;
import com.hz.gc.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

*/
/**
 *   用于保存我们从数据库中查出来的数据，其功能主要是验证账号状态和获取权限的.
 *//*

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"enabled","accountNonExpired", "accountNonLocked", "credentialsNonExpired", "authorities"})
public class SecurityUser implements UserDetails, Serializable {

    // 封装用户输入的用户名
    private String username;
    // 密码
    private String password;
    // 角色
    private List<Role> roleInfo;
    // 权限列表
    private List<String> permissions;
    // 权限对象
    private List<Permissions> permissionList ;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 通过UserDetailsService去数据库查询将用户的相关信息封装到UserDetails中
        // 然后将权限赋值给GrantedAuthority,这样后续security就可以权限验证了.
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for(String permissionValue : permissions) {
            if(StringUtils.isEmpty(permissionValue)) continue;
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permissionValue);
            System.out.println("authority = " + authority);
            authorities.add(authority);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
*/
