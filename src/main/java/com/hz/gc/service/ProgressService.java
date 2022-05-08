package com.hz.gc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.pojo.Progress;
import com.hz.gc.vo.ProgressVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ProgressService extends IService<Progress> {

    List<ProgressVo> findProgressList(Integer page, Integer page_size,String itemProjectName);

    Integer findProgressListCount(String itemProjectName);

    int saveProgress(String itemProjectName);

    int updateProgress(Integer progressId,String itemProjectName);
}
