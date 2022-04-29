package com.hz.gc.dao;

import com.hz.gc.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Component
public interface UserDao extends BaseMapper<User> {
    User selectUserById(Integer userId);

    int deleteUserById(Integer userId);

    int updateUserById(User user);

    int addUser(User user);

    List<User> findUserList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("userName") String userName,
            @Param("positionName") String positionName);

    Integer findUserListCount(
            @Param("userName") String userName,
            @Param("positionName") String positionName);

    /*List<User> selectUserList();*/
}
