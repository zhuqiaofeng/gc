package com.hz.gc.service;

import com.hz.gc.pojo.User;
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
public interface UserService extends IService<User> {
    User selectUserById(Integer userId);

    int deleteUserById(Integer userId);

    int updateUserById(User user);

    int addUser(User user);

    List<User> findUserList( Integer curr_page, Integer page_size, String userName, String positionName);

    Integer findUserListCount(String userName, String positionName);



/*

    User findUserById(Integer userId);

    List<User> findUserList();

    boolean saveUser(User user);

    boolean deleteUserById(Integer userId);
*/

}
