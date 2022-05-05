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

    /**
     * 根据ID查询信息
     * @param dailyProgressId
     * @return
     */
    DailyProgress selectDailyProgressById(Integer dailyProgressId);

    int addDailyProgress(DailyProgress dailyProgress);
}
