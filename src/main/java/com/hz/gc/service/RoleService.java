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

    List<Role> getRoleListByIds(List<Integer> roleIds);
}
