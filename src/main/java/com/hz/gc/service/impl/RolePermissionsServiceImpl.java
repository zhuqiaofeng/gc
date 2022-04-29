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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRoleIds(Integer roleId) {
        QueryWrapper<RolePermissions> wrapper = new QueryWrapper<>();
        wrapper.eq("roleId",roleId);

        return this.remove(wrapper);
    }

    /**
     *  为角色分配权限,即把角色和权限建立关系即可
     * @param roleId 角色id
     * @param permIds 权限id集合
     * @return 是否批量添加成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addPermission(Integer roleId, List<Integer> permIds) {

        List<RolePermissions> relations = new ArrayList<>();
        for (Integer permissionId : permIds) {
            RolePermissions relation = new RolePermissions();
            relation.setRoleId(roleId);
            relation.setPermId(permissionId);
            relations.add(relation);
        }
        return this.saveBatch(relations);
    }

    @Override
    public List<Integer> getRoleIds(Integer permId) {
        QueryWrapper<RolePermissions> wrapper = new QueryWrapper<>();
        wrapper.notIn("permId",permId);
        List<RolePermissions> relations = rolePermissionsDao.selectList(wrapper);
        if(relations != null && relations.size() >0 ){
            List<Integer> roleIds = relations.stream().map(map -> {

                return map.getRoleId();
            }).collect(Collectors.toList());

            return roleIds;
        }
        return null;
    }
}
