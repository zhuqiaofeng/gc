package com.hz.gc.controller;

import com.hz.gc.pojo.Progress;
import com.hz.gc.service.ProgressService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @RequestMapping(value = "/findPositionList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Progress>> findPositionList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size
    ){
        List<Progress> list = progressService.findProgressList(page,page_size);
        Integer count = progressService.findProgressListCount();

        JsonMassage<List<Progress>> jsonMassage = new JsonMassage<List<Progress>>();
        jsonMassage.setCode(200);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }


    @RequestMapping(value = "/saveProgress",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson saveProgress(String itemProjectName){
        int i = progressService.saveProgress(itemProjectName);
        return new ResultJson(i);
    }

    @ResponseBody
    @RequestMapping(value = "/updateProgress",method = RequestMethod.POST)
    public ResultJson updateProgress(Integer progressId,String itemProjectName){
        int i = progressService.updateProgress(progressId,itemProjectName);
        return new ResultJson(i);
    }
}
