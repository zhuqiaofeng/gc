package com.hz.gc.service;

import com.hz.gc.pojo.TotalProject;
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
public interface TotalProjectService extends IService<TotalProject> {

    int saveTotalProject(TotalProject totalProject);

    int deleteTotalProjectById(Integer totalProjectId);

    TotalProject findTotalProjectById(Integer totalProjectId);

    int updateTotalProject(TotalProject totalProject);

    List<TotalProject> findTotalProjectList(Integer page, Integer page_size, String totalProjectName, String totalProjectDesc);

    Integer findTotalProjectListCount(String totalProjectName, String totalProjectDesc);

    List<TotalProject> findTotalProjectNameList();
}
