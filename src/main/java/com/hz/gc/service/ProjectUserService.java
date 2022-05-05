package com.hz.gc.service;

import com.hz.gc.pojo.ProjectUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.vo.ProjectUserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ProjectUserService extends IService<ProjectUser> {

    int addProjectUser(ProjectUser projectUser);

    int deleteProjectUser(Integer projectUserId);

    int updateProjectUser(Integer projectUserId);

    List<ProjectUserVo> selectProjectUserList(Integer curr_page,Integer page_size,String totalProjectName,String userName);

    int selectProjectUserListCount(String totalProjectName,String userName);
}
