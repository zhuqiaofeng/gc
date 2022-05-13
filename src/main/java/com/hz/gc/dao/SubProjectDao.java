package com.hz.gc.dao;

import com.hz.gc.pojo.SubProject;
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
public interface SubProjectDao extends BaseMapper<SubProject> {
    /**
     * 多条件组合查询
     * 翻页查询供应商信息
     * @param pyl  偏移量
     * @param page_size 每页显示条数
     * @return
     */

    public List<SubProject> findSubProjectList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("subProjectName")String subProjectName,
            @Param("subProjectDesc")String subProjectDesc
    );

    Integer findSubProjectListCount( @Param("subProjectName")String subProjectName,
                                     @Param("subProjectDesc")String subProjectDesc);

  //根据id删除
    public int deleteSubProjectById(Integer subProjectId);



    //修改
    public int updateSubProject(SubProject subProject);


      //新  增

    public int saveSubProject(SubProject subProject);

//根据id查询
    SubProject selectSubProjectById(@Param("subProjectId") Integer subProjectId);

    List<SubProject> findSubProjectNameList();

//    List<SubProject> findSubProjectList(
//            @Param("pyl") Integer pyl,
//            @Param("page_size") Integer page_size,
//            @Param("subProjectName") String subProjectName,
//            @Param("subProjectDesc") String subProjectDesc);

//    Integer findSubProjectListCount(
//            @Param("subProjectName") String subProjectName,
//            @Param("subProjectDesc") String subProjectDesc);

}
