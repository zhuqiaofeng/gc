package com.hz.gc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.vo.DailyProgressUserVo;
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
public interface DailyProgressDao extends BaseMapper<DailyProgress> {

    DailyProgress selectDailyProgressById(Integer dailyProgressId);

    int addDailyProgress(DailyProgressUserVo dailyProgressUserVo);

    DailyProgress selectDate(String itemProjectName);

    List<DailyProgressUserVo> findDailyProgressList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("userName") String userName,
            @Param("itemProjectName") String itemProjectName);

    Integer findDailyProgressListCount(
            @Param("userName") String userName,
            @Param("itemProjectName") String itemProjectName);
}
