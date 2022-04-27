package com.hz.gc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.pojo.Permissions;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface PermissionsService extends IService<Permissions> {

    List<String> getPermissionByUserId(Integer userId);

    Permissions findAuthorityByUrl(String url);
}
