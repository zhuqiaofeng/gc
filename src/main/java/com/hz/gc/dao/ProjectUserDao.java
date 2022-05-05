package com.hz.gc.dao;

import com.hz.gc.pojo.ProjectUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.gc.vo.ProjectUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ProjectUserDao extends BaseMapper<ProjectUser> {

    int addProjectUser(ProjectUser projectUser);

    int deleteProjectUser(Integer projectUserId);

    int updateProjectUser(Integer projectUserId);

    List<ProjectUserVo> selectProjectUserList(
            @Param("page_size") Integer page_size,
            @Param("pyl") Integer pyl,
            @Param("totalProjectName") String totalProjectName,
            @Param("userName") String userName);

    Integer selectProjectUserListCount(
            @Param("totalProjectName") String totalProjectName,
            @Param("userName") String userName);
}
