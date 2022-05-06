package com.hz.gc.controller;

import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.service.DailyProgressService;
import com.hz.gc.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/dailyProgress")
public class DailyProgressController {
    @Autowired
    private DailyProgressService dailyProgressService;

    @RequestMapping(value = "/addDailyProgress",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addDailyProgress(DailyProgress dailyProgress){
        int i = dailyProgressService.addDailyProgress(dailyProgress);
        return new ResultJson(i);
    }


    /**
     * 根据ID查询信息
     * @param dailyProgressId
     * @return
     */
    @PostMapping(value = "/selectDailyProgressById")

    public ResultJson<DailyProgress> selectDailyProgressById(Integer dailyProgressId){
        DailyProgress dailyProgress = dailyProgressService.selectDailyProgressById(dailyProgressId);
        return new ResultJson<DailyProgress>(200,"成功",dailyProgress);
    }

}
