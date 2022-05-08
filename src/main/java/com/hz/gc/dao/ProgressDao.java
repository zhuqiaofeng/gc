package com.hz.gc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.gc.pojo.Progress;
import com.hz.gc.vo.ProgressVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ProgressDao extends BaseMapper<Progress> {

    List<ProgressVo> findProgressList(
            @Param("pyl") Integer pyl,
            @Param("page_size")Integer page_size,
            @Param("itemProjectName") String itemProjectName
    );

    int findProgressListCount(String itemProjectName);

    int saveProgress(String itemProjectName);

    int updateProgressDate(
           @Param("progressId") Integer progressId,
           @Param("progressActualStart") String progressActualStart,
           @Param("progressActualEnd") String progressActualEnd
    );
}
