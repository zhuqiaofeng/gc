package com.hz.gc.service.impl;

import com.hz.gc.pojo.TotalProject;
import com.hz.gc.dao.TotalProjectDao;
import com.hz.gc.service.TotalProjectService;
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
public class TotalProjectServiceImpl extends ServiceImpl<TotalProjectDao, TotalProject> implements TotalProjectService {

    @Autowired
    private TotalProjectDao totalProjectDao;
    @Override
    public int saveTotalProject(TotalProject totalProject) {
        int i = totalProjectDao.insert(totalProject);
        return i;
    }

    @Override
    public int deleteTotalProjectById(Integer totalProjectId) {
        int i = totalProjectDao.deleteTotalProjectById(totalProjectId);
        return i;
    }

    @Override
    public TotalProject findTotalProjectById(Integer totalProjectId) {

        return totalProjectDao.findTotalProjectById(totalProjectId);
    }

    @Override
    public int updateTotalProject(TotalProject totalProject) {
        int i = totalProjectDao.updateById(totalProject);
        return i;
    }

    @Override
    public List<TotalProject> findTotalProjectList(Integer page, Integer page_size, String totalProjectName, String totalProjectDesc) {
        Integer pyl = (page-1)*page_size;

        return totalProjectDao.findTotalProjectList(pyl,page_size,totalProjectName,totalProjectDesc);
    }

    @Override
    public Integer findTotalProjectListCount(String totalProjectName, String totalProjectDesc) {
        return totalProjectDao.findTotalProjectListCount(totalProjectName,totalProjectDesc);
    }
}
