package com.hz.gc.dao;

import com.hz.gc.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    List<User> selectUserList();
}
