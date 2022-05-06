package com.hz.gc.service.impl;

import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.dao.DailyProgressDao;
import com.hz.gc.service.DailyProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
public class DailyProgressServiceImpl extends ServiceImpl<DailyProgressDao, DailyProgress> implements DailyProgressService {

    @Autowired
    private DailyProgressDao dailyProgressDao;
    /**
     * 根据ID查询信息
     * @param dailyProgressId
     * @return
     */
    @Override
    public DailyProgress selectDailyProgressById(Integer dailyProgressId) {
        DailyProgress dailyProgress  = dailyProgressDao.selectDailyProgressById(dailyProgressId);
        return dailyProgress;
    }

    @Override
    public int addDailyProgress(DailyProgress dailyProgress) {
        int i = dailyProgressDao.addDailyProgress(dailyProgress);
        return i;
    }
}
