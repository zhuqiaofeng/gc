package com.hz.gc.service;

import com.hz.gc.pojo.RolePermissions;
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
public interface RolePermissionsService extends IService<RolePermissions> {

    List<Integer> selectPermissionIdsListByRoleId(Integer roleId);
}
