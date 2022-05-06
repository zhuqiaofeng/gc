package com.hz.gc.dao;

import com.hz.gc.pojo.TotalProject;
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
public interface TotalProjectDao extends BaseMapper<TotalProject> {

    int deleteTotalProjectById(Integer totalProjectId);

    TotalProject findTotalProjectById(Integer totalProjectId);

    List<TotalProject> findTotalProjectList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("totalProjectName") String totalProjectName,
            @Param("totalProjectDesc") String totalProjectDesc
    );

    Integer findTotalProjectListCount(
            @Param("totalProjectName") String totalProjectName,
            @Param("totalProjectDesc") String totalProjectDesc);
//添加
    int saveTotalProject(TotalProject totalProject);

    int updateTotalProject(TotalProject totalProject);
}
