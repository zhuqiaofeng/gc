/*
package com.hz.gc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.gc.common.ResponseState;
import com.hz.gc.dao.PermissionsDao;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.Permissions;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.pojo.Role;
import com.hz.gc.service.PermissionsService;
import com.hz.gc.service.RolePermissionsService;
import com.hz.gc.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 *//*

@Service
@Slf4j
public class PermissionsServiceImpl extends ServiceImpl<PermissionsDao, Permissions> implements PermissionsService {
    @Autowired
    private PermissionsDao permissionsDao;
    @Autowired
    private RolePermissionsService rolePermissionsService;
    @Autowired
    private RoleService roleService;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    */
/**
     *  通过角色来获取权限
     * @param userId 此用户
     * @return
     *//*

    @Override
    public List<String> getPermissionByUserId(Integer userId) {

        log.info("进入到了getPermissionByUserId()方法...");
        if(userId == null){

            throw new GcException(ResponseState.WITHOUT_PERMISSION,"此用户还未分配角色");
        }

        List<String> permissionPath = permissionsDao.findPermissionPathByUserId(userId);

        if (permissionPath.size() <= 0){;
            throw new GcException(ResponseState.WITHOUT_PERMISSION,"此用户无权限");
        }

        return permissionPath;
    }

    */
/*
        根据path来查对应的权限
     *//*

    @Override
    public Permissions findAuthorityByUrl(String url) {
        QueryWrapper<Permissions> wrapper = new QueryWrapper<>();
        wrapper.eq("permUrl",url);

        // 此处不需要判断是否为空,留给调用者来判断.
        return permissionsDao.selectOne(wrapper);
    }

    */
/*
            递归查询此用户所有权限
         *//*

    @Override
    public List<Permissions> getPermissionListByUserId(Integer userId) {
        List<Permissions> tree = new ArrayList<>();
        List<Permissions> permissionList = permissionsDao.getPermissionListByUserId(userId);
        for (Permissions permission : permissionList) {
            if(permission.getParentId() == 0){
                this.getChildTree(permission,permissionList);
                tree.add(permission);
            }
        }
        return tree;
    }

    */
/**
     *  递归查询方法
     *//*


    private void getChildTree(Permissions permission, List<Permissions> permissionList) {

        List<Permissions> children = new ArrayList<>();
        for (Permissions item : permissionList) {
            if(permission.getPermId().equals(item.getParentId())){
                children.add(item);
            }
        }
        if(children.size() == 0){
            return;
        }
        permission.setChildren(children);
        for (Permissions child : children) {
            getChildTree(child,permissionList);
        }
    }

    */
/**
     *  删除菜单栏
     *//*

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteMenuByPid(Integer id) {
        if(id == null){
            throw new GcException(ResponseState.SERVER_ERROR,"菜单不存在");
        }
        long begin = System.currentTimeMillis();
        List<Integer> ids = new ArrayList<>();
        this.getChildIds(id,ids);
        ids.add(id);
        long end = System.currentTimeMillis();
        log.info("删除菜单栏耗时:{} ms ......",begin-end);
        return this.removeBatchByIds(ids);

    }


    */
/**
     *  收集父级菜单下的所有菜单id
     *//*

    private void getChildIds(Integer id, List<Integer> ids) {
        List<Permissions> permissions = (List<Permissions>) redisTemplate.opsForValue().get(ResponseState.PERMISSION_LIST);
        System.out.println("permissions = " + permissions);
        if(permissions != null && permissions.size() > 0){
            permissions.stream().filter(item -> id.equals(item.getParentId())).forEach((map) -> {
                Integer childId = map.getPermId();
                ids.add(childId);
                this.getChildIds(map.getPermId(),ids);
            });
        }else{
            permissions = permissionsDao.selectList(null);
            permissions.stream().filter(item -> id.equals(item.getParentId())).forEach((map) -> {
                Integer childId = map.getPermId();
                ids.add(childId);
                this.getChildIds(map.getPermId(),ids);
            });
            redisTemplate.opsForValue().set(ResponseState.PERMISSION_LIST,permissions);
        }
    }

    */
/**
     *  为角色分配权限
     * @param roleId 角色id
     * @param permIds 权限集合
     * @return 结果 true ok  false error
     *//*

    @Override
    public boolean forRoleAllotPermission(Integer roleId, List<Integer> permIds) {

        if(roleId == null || permIds.size() == 0){

            throw new GcException(ResponseState.SERVER_ERROR,"参数异常..");
        }

        return rolePermissionsService.addPermission(roleId,permIds);
    }

   */
/* @Override
    public List<Role> getWithOutPermissionTheRoles(Integer permId) {

        // 可以为空 不能为null,为空则代表此权限所有角色都已经有了
        List<Integer> ids =  rolePermissionsService.getRoleIds(permId);

        if(ids == null){
            throw new GcException(ResponseState.SERVER_ERROR,"获取错误,参数异常..");
        }
        List<Role> roles = new ArrayList<>();
        // 为0则说明当前用户都已经拥有此权限了
        if(ids.size() == 0){
            return roles;
        }

        roles = roleService.getRoleListByIds(ids);

        return  roles;

    }*//*


}
*/
