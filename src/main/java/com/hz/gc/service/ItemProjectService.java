package com.hz.gc.service;

import com.hz.gc.pojo.ItemProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.vo.ProjectUserVo;
import com.hz.gc.vo.itemVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ItemProjectService extends IService<ItemProject> {
//新增
    int saveItemProject(ItemProject itemProject);
//删除
    int deleteItemProjectById(Integer itemProjectId);
//根据id修改
    int updateItemProjectById(ItemProject itemProject);
//根据id查询信息
ItemProject findItemProjectById(Integer itemProjectId);

    List<itemVo> finditemProjectList(Integer curr_page, Integer page_size, String itemProjectName, String itemProjectDesc);


    Integer finditemProjectListCount(String itemProjectName, String itemProjectDesc);
}
