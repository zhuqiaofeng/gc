package com.hz.gc.service.impl;

import com.hz.gc.pojo.ItemProject;
import com.hz.gc.dao.ItemProjectDao;
import com.hz.gc.service.ItemProjectService;
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
public class ItemProjectServiceImpl extends ServiceImpl<ItemProjectDao, ItemProject> implements ItemProjectService {

    @Autowired
    private ItemProjectDao itemProjectDao;

    @Override
    public int saveItemProject(ItemProject itemProject) {
        return itemProjectDao.saveItemProject(itemProject);
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
    public List<ItemProject> finditemProjectList(Integer curr_page, Integer page_size, String userName, String positionName) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (curr_page-1)*page_size;

        List<ItemProject> users = itemProjectDao.finditemProjectList(pyl,page_size,userName,positionName);

        return users;
    }

    @Override
    public Integer finditemProjectListCount(String itemProjectName, String itemProjectDesc) {


        return itemProjectDao.finditemProjectListCount(itemProjectName,itemProjectDesc);
    }
}
