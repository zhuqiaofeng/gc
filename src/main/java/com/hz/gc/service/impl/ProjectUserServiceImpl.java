package com.hz.gc.service.impl;

import com.hz.gc.pojo.ProjectUser;
import com.hz.gc.dao.ProjectUserDao;
import com.hz.gc.service.ProjectUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.vo.ProjectUserVo;
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
public class ProjectUserServiceImpl extends ServiceImpl<ProjectUserDao, ProjectUser> implements ProjectUserService {

    @Autowired
    private ProjectUserDao projectUserDao;

    @Override
    public int addProjectUser(ProjectUser projectUser) {
        return projectUserDao.addProjectUser(projectUser);
    }

    @Override
    public int deleteProjectUser(Integer projectUserId) {
        return projectUserDao.deleteProjectUser(projectUserId);
    }

    @Override
    public int updateProjectUser(Integer projectUserId) {
        return projectUserDao.updateProjectUser(projectUserId);
    }

    @Override
    public List<ProjectUserVo> selectProjectUserList(Integer curr_page, Integer page_size, String totalProjectName, String userName) {
        int pyl=(curr_page-1)*page_size;
        return projectUserDao.selectProjectUserList(pyl,page_size,totalProjectName,userName);
    }

    @Override
    public int selectProjectUserListCount(String totalProjectName, String userName) {
        return projectUserDao.selectProjectUserListCount(totalProjectName,userName);
    }


}
