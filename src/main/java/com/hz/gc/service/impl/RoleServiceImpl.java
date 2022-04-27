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
    public List<Role> getRoleListByIds(List<Integer> roleIds) {
        List<Role> roles = roleDao.selectBatchIds(roleIds);

        if(roles.size() <= 0){

            throw new GcException(ResponseState.SERVER_ERROR,"当前id当中没有此角色");
        }
        return roles;
    }
}
