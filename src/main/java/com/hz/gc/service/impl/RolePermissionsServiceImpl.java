package com.hz.gc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.gc.common.ResponseState;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.RolePermissions;
import com.hz.gc.dao.RolePermissionsDao;
import com.hz.gc.service.RolePermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
@Slf4j
public class RolePermissionsServiceImpl extends ServiceImpl<RolePermissionsDao, RolePermissions> implements RolePermissionsService {
    @Autowired
    private RolePermissionsDao rolePermissionsDao;
    /*
       通过角色id来查询对应的权限id
    */
    @Override
    public List<Integer> selectPermissionIdsListByRoleId(Integer roleId) {
        log.info("进入到了selectPermissionListByRoleId方法");
        if(roleId == null){

            throw new GcException(ResponseState.SERVER_ERROR,"角色id出现错误");
        }

        List<RolePermissions> relations = rolePermissionsDao.selectList(new QueryWrapper<RolePermissions>()
                .eq("roleId", roleId));

        if(relations.size() <= 0){
            throw new GcException(ResponseState.WITHOUT_PERMISSION,"用户没有对应的权限");
        }

        // 拿到角色对应的所有权限id,收集成一个集合返回

        List<Integer> permissionIds = relations.stream().map(item -> {

            return item.getPermId();
        }).collect(Collectors.toList());


        return permissionIds;
    }
}
