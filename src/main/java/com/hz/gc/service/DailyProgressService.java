package com.hz.gc.service;

import com.hz.gc.pojo.DailyProgress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface DailyProgressService extends IService<DailyProgress> {
    /**
     * 根据ID查询信息
     * @param dailyProgressId
     * @return
     */
    DailyProgress selectDailyProgressById(Integer dailyProgressId);

    int addDailyProgress(DailyProgress dailyProgress);
}
