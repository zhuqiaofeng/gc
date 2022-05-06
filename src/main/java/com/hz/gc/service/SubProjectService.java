package com.hz.gc.service;

import com.hz.gc.pojo.SubProject;
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
public interface SubProjectService extends IService<SubProject> {


    public List<SubProject> findSubProjectList(
            Integer curr_page, Integer page_size,
            String subProjectName,
            String subProjectDesc
    );
    public Integer findSubProjectListCount(String subProjectName, String subProjectDesc);

//根据id删除
    public int deleteSubProjectById(Integer subProjectId);

//修改
    public int updateSubProject(SubProject subProject);


   //新增
    public int saveSubProject(SubProject subProject);

//根据id查询
    SubProject selectSubProjectById(Integer subProjectId);
}
