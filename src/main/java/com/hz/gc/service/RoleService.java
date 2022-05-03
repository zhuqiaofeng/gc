package com.hz.gc.service;

import com.hz.gc.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface RoleService extends IService<Role> {

    Role selectRoleById(Integer roleId);

   // List<Role> getRoleListByIds(List<Integer> roleIds);

    int updateRole(Role role);

    int addRole(Role role);

    //根据删除角色
    int deleteRoleById(Integer roleId);

    List<Role> findRoleList(Integer page, Integer page_size,String roleName);

    int findRoleListCount(String roleName);

   // List<Role> getRoleListByIds(List<Integer> ids);
}
