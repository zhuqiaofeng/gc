package com.hz.gc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.gc.pojo.Permissions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Resource
public interface PermissionsDao extends BaseMapper<Permissions> {

    List<String> findPermissionPathByUserId(Integer userId);

    List<Permissions> getPermissionListByUserId(Integer userId);
}
