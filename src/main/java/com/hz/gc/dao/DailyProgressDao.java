package com.hz.gc.dao;

import com.hz.gc.pojo.DailyProgress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    int addDailyProgress(DailyProgress dailyProgress);

    DailyProgress selectDate(String itemProjectName);
}
