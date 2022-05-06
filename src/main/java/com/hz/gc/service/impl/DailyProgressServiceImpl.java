package com.hz.gc.service.impl;

import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.dao.DailyProgressDao;
import com.hz.gc.service.DailyProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.gc.vo.DailyProgressUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public int addDailyProgress(DailyProgressUserVo dailyProgressUserVo) {
        int i = dailyProgressDao.addDailyProgress(dailyProgressUserVo);
        return i;
    }

    @Override
    public List<DailyProgressUserVo> findDailyProgressList(Integer page, Integer page_size, String userName, String itemProjectName) {
        Integer pyl = (page-1)*page_size;

        return dailyProgressDao.findDailyProgressList(pyl,page_size,userName,itemProjectName);
    }

    @Override
    public Integer findDailyProgressListCount(String userName, String itemProjectName) {
        return dailyProgressDao.findDailyProgressListCount(userName,itemProjectName);
    }

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
}
