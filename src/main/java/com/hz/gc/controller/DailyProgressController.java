package com.hz.gc.controller;

import com.hz.gc.pojo.DailyProgress;
import com.hz.gc.service.DailyProgressService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import com.hz.gc.vo.DailyProgressUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Controller
@RequestMapping("/dailyProgress")
public class DailyProgressController {
    @Autowired
    private DailyProgressService dailyProgressService;

    /**
     * 添加每日进度
     * @param dailyProgressUserVo
     * @return
     */
    @RequestMapping(value = "/addDailyProgress",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addDailyProgress( @RequestBody DailyProgressUserVo dailyProgressUserVo){
        System.out.println(dailyProgressUserVo);
        int i = dailyProgressService.addDailyProgress(dailyProgressUserVo);
        return new ResultJson(i);
    }


    /**
     * 分页查询  多条件
     * @param page  当前页
     * @param page_size 每页显示条数
     * @return
     */
    @RequestMapping(value = "/findDailyProgressList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<DailyProgressUserVo>> findProviderList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String userName,
            String itemProjectName
    ){
        List<DailyProgressUserVo> list = dailyProgressService.findDailyProgressList(page,page_size,userName,itemProjectName);
        Integer count = dailyProgressService.findDailyProgressListCount(userName,itemProjectName);

        JsonMassage<List<DailyProgressUserVo>> jsonMassage = new JsonMassage<List<DailyProgressUserVo>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }




    /**
     * 根据ID查询进度信息
     * @param dailyProgressId
     * @return
     */
    @PostMapping(value = "/selectDailyProgressById")

    public ResultJson<DailyProgress> selectDailyProgressById(Integer dailyProgressId){
        DailyProgress dailyProgress = dailyProgressService.selectDailyProgressById(dailyProgressId);
        return new ResultJson<DailyProgress>(200,"成功",dailyProgress);
    }

}
