package com.hz.gc.service.impl;

import com.hz.gc.common.ResponseState;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.User;
import com.hz.gc.dao.UserDao;
import com.hz.gc.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Integer userId) {
        User user = userDao.selectById(userId);

        if(user == null){
            throw new GcException(ResponseState.SERVER_ERROR, ResponseState.REQUEST_FAILURE);
        }
        return user;
    }

    @Override
    public List<User> findUserList() {
        List<User> users = userDao.selectUserList();

        return users;
    }
}
