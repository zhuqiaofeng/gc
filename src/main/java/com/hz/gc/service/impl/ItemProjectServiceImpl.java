package com.hz.gc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.dao.ItemProjectDao;
import com.hz.gc.dao.ProgressDao;
import com.hz.gc.pojo.ItemProject;
import com.hz.gc.service.ItemProjectService;
import com.hz.gc.vo.itemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class ItemProjectServiceImpl extends ServiceImpl<ItemProjectDao, ItemProject> implements ItemProjectService {

    @Autowired
    private ItemProjectDao itemProjectDao;

    @Autowired
    private ProgressDao progressDao;

    /**
     * 新建分项工程同时添加进度统计
     * @param itemProject
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            timeout = -1)
    @Override
    public int saveItemProject(ItemProject itemProject) {

        int i = itemProjectDao.saveItemProject(itemProject);
        String itemProjectName = itemProject.getItemProjectName();
        progressDao.saveProgress(itemProjectName);

        return i;
    }
    //根据id删除
    @Override
    public int deleteItemProjectById(Integer itemProjectId) {
        return itemProjectDao.deleteItemProjectById(itemProjectId);
    }
//根据id修改
    @Override
    public int updateItemProjectById(ItemProject itemProject) {
        int i= itemProjectDao.updateItemProjectById(itemProject);
        return i;
    }
//根据id查询
    @Override
    public ItemProject findItemProjectById(Integer itemProjectId) {
    return itemProjectDao.findItemProjectById(itemProjectId);
}
    @Override
    public List<itemVo> findItemProjectList(Integer page, Integer page_size, String itemProjectName, String itemProjectDesc) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (page-1)*page_size;
        return  itemProjectDao.findItemProjectList(pyl,page_size,itemProjectName,itemProjectDesc);
    }
    @Override
    public Integer findItemProjectListCount(String itemProjectName, String itemProjectDesc) {
        return itemProjectDao.findItemProjectListCount(itemProjectName,itemProjectDesc);
    }
}
