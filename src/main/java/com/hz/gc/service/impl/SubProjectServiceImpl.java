package com.hz.gc.service.impl;

import com.hz.gc.pojo.SubProject;
import com.hz.gc.dao.SubProjectDao;
import com.hz.gc.service.SubProjectService;
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
public class SubProjectServiceImpl extends ServiceImpl<SubProjectDao, SubProject> implements SubProjectService {

    @Autowired
    private SubProjectDao subProjectDao;




    //    多条件组合查询
    @Override
    public List<SubProject> findSubProjectList(Integer curr_page, Integer page_size, String subProjectName, String subProjectDesc) {

        Integer pyl = (curr_page-1)*page_size;
        return subProjectDao.findSubProjectList(pyl,page_size,subProjectName,subProjectDesc);
    }

    //计算条数
    @Override
    public Integer findSubProjectListCount(String subProjectName, String subProjectDesc) {
        return subProjectDao.findSubProjectListCount(subProjectName,subProjectDesc);
    }
    //根据id删除
    @Override
    public int deleteSubProjectById(Integer subProjectId) {
        return subProjectDao.deleteSubProjectById(subProjectId);
    }

    //根据id修改
    @Override
    public int updateSubProject(SubProject subProject) {
        return subProjectDao.updateSubProject(subProject);
    }
    @Override
    //新增
    public int saveSubProject(SubProject subProject) {
        return subProjectDao.saveSubProject(subProject);
    }
//根据id查询
    @Override
    public SubProject selectSubProjectById(Integer subProjectId) {

            return subProjectDao.selectSubProjectById(subProjectId);
    }

}
