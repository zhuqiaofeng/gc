package com.hz.gc.service.impl;

import com.hz.gc.pojo.User;
import com.hz.gc.dao.UserDao;
import com.hz.gc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
