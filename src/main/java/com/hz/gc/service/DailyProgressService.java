package com.hz.gc.service;

import com.hz.gc.pojo.DailyProgress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.vo.DailyProgressUserVo;

import java.util.List;

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

    int addDailyProgress(DailyProgressUserVo dailyProgressUserVo);

    List<DailyProgressUserVo> findDailyProgressList(Integer page, Integer page_size, String userName, String itemProjectName);

    Integer findDailyProgressListCount(String userName, String itemProjectName);
}
