package com.hz.gc.dao;

import com.hz.gc.pojo.ItemProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Component
public interface ItemProjectDao extends BaseMapper<ItemProject> {


    //新  增

    public int saveItemProject(ItemProject itemProject);

    //根据id删除
    public int deleteItemProjectById(Integer itemProjectId);
//根据id修改
    int updateItemProjectById(ItemProject itemProject);

    //根据id查询
    ItemProject findItemProjectById(Integer itemProjectId);

    List<ItemProject> findItemProjectList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("itemProjectName") String itemProjectName,
            @Param("itemProjectDesc") String itemProjectDesc);

    Integer findItemProjectListCount(
            @Param("itemProjectName") String itemProjectName,
            @Param("itemProjectDesc") String itemProjectDesc);

}
