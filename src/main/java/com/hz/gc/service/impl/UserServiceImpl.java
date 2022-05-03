package com.hz.gc.service.impl;

import com.hz.gc.common.ResponseState;
import com.hz.gc.common.SomsConstants;
import com.hz.gc.exception.GcException;
import com.hz.gc.pojo.User;
import com.hz.gc.dao.UserDao;
import com.hz.gc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.utils.MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User selectUserById(Integer userId) {

       User user = userDao.selectUserById(userId);
        return user;
    }

    @Override
    public int deleteUserById(Integer userId) {

        int i = userDao.deleteUserById(userId);
        return i;
    }

    @Override
    public int updateUserById(User user) {
        int i = userDao.updateUserById(user);
        return i;
    }

    @Override
    public int addUser(User user) {
        int i = userDao.addUser(user);
        return i;
    }

    @Override
    public List<User> findUserList( Integer curr_page, Integer page_size, String userName, String positionName) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (curr_page-1)*page_size;

        List<User> users = userDao.findUserList(pyl,page_size,userName,positionName);

        return users;
    }

    @Override
    public Integer findUserListCount(String userName, String positionName) {


        return userDao.findUserListCount(userName,positionName);
    }




























    /*    *//**
     *根据ID查询用户信息
     * @param userId
     * @return
     *//*
    @Override
    public User findUserById(Integer userId) {
        User user = userDao.selectById(userId);

        if(user == null){
            throw new GcException(ResponseState.SERVER_ERROR, ResponseState.REQUEST_FAILURE);
        }
        return user;
    }

    *//**
     * 获取所有用户信息
     * @return
     *//*
    @Override
    public List<User> findUserList() {
        List<User> users = userDao.selectUserList();

        if(users == null){
            throw new GcException(ResponseState.SERVER_ERROR, ResponseState.REQUEST_FAILURE);
        }

        return users;
    }


    *//**
     * 添加用户信息
     *//*
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveUser(User user) {

        if(user == null){
            throw new GcException(ResponseState.SERVER_ERROR,"添加信息不存在");
        }
        String userPassword = user.getUserPassword();
        if(StringUtils.isNotBlank(userPassword)){
            userPassword = MD5.encrypt(userPassword);
            user.setUserPassword(userPassword);
        }
        return this.save(user);
    }

    *//**
     * 根据ID删除用户
     * @param userId
     * @return
     *//*
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean deleteUserById(Integer userId) {

        int count = userDao.deleteById(userId);
        if(count != 1){
            //log.error("删除用户时出现异常,异常方法是:{}","deleteUserById()");
            throw new GcException(ResponseState.SERVER_ERROR,"删除用户失败");
        }

        return true;
    }*/


}
