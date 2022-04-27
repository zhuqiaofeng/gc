package com.hz.gc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.gc.common.ResponseState;
import com.hz.gc.dao.PermissionsDao;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.Permissions;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.service.PermissionsService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PermissionsServiceImpl extends ServiceImpl<PermissionsDao, Permissions> implements PermissionsService {
    @Autowired
    private PermissionsDao permissionsDao;

    /**
     *  通过角色来获取权限
     * @param userId 此用户
     * @return
     */
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

    /*
        根据path来查对应的权限
     */
    @Override
    public Permissions findAuthorityByUrl(String url) {
        QueryWrapper<Permissions> wrapper = new QueryWrapper<>();
        wrapper.eq("permUrl",url);

        // 此处不需要判断是否为空,留给调用者来判断.
        return permissionsDao.selectOne(wrapper);
    }


}
