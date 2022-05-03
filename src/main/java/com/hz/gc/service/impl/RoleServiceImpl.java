package com.hz.gc.service.impl;

import com.hz.gc.common.ResponseState;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.Role;
import com.hz.gc.dao.RoleDao;
import com.hz.gc.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role selectRoleById(Integer roleId) {
        return roleDao.selectRoleById(roleId);
    }

   /* @Override
    public List<Role> getRoleListByIds(List<Integer> roleIds) {
        List<Role> roles = roleDao.selectBatchIds(roleIds);

        if(roles.size() <= 0){

            throw new GcException(ResponseState.SERVER_ERROR,"当前id当中没有此角色");
        }
        return roles;
    }*/

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public int deleteRoleById(Integer roleId) {
        return roleDao.deleteRoleById(roleId);
    }

    @Override
    public List<Role> findRoleList(Integer page, Integer page_size,String roleName) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (page-1)*page_size;
        return roleDao.findRoleList(pyl,page_size,roleName);

    }

    @Override
    public int findRoleListCount(String roleName) {
        return roleDao.findRoleListCount(roleName);
    }


}
