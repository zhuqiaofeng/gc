package com.hz.gc.dao;

import com.hz.gc.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface RoleDao extends BaseMapper<Role> {

    //根据角色id查询数据
    Role selectRoleById(Integer roleId);

    //修改角色信息
    int updateRole(Role role);

    //添加角色信息
    int addRole(Role role);

    //根据ID删除角色信息
    int deleteRoleById(Integer roleId);

    List<Role> findRoleList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("roleName") String roleName);

    //获得总条数
    int findRoleListCount(String roleName);
}
