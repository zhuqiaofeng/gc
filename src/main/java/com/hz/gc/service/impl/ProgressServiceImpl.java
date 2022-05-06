package com.hz.gc.service.impl;

import com.hz.gc.dao.DailyProgressDao;
import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.pojo.Progress;
import com.hz.gc.dao.ProgressDao;
import com.hz.gc.service.ProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class ProgressServiceImpl extends ServiceImpl<ProgressDao, Progress> implements ProgressService {

    @Autowired
    private ProgressDao progressDao;

    @Autowired
    private DailyProgressDao dailyProgressDao;

    @Override
    public List<Progress> findProgressList(Integer page, Integer page_size) {

        Integer pyl = (page-1)*page_size;

        return progressDao.findProgressList(pyl,page_size);
    }

    @Override
    public Integer findProgressListCount() {
        int i = progressDao.findProgressListCount();
        return i;
    }

    @Override
    public int saveProgress(String itemProjectName) {
        int i = progressDao.saveProgress(itemProjectName);
        return i;
    }


    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            timeout = -1)
    @Override
    public int updateProgress(Integer progressId, String itemProjectName) {

        DailyProgress dailyProgress = dailyProgressDao.selectDate(itemProjectName);

        if(dailyProgress == null){
            throw new NullPointerException("工程暂无进度");
        }else{
            String progressActualStart = dailyProgress.getProgressActualStart();
            String progressActualEnd = dailyProgress.getProgressActualEnd();
            int i = progressDao.updateProgressDate(progressId, progressActualStart, progressActualEnd);
            return i;
        }
    }
}
