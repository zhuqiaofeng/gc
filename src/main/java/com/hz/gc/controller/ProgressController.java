package com.hz.gc.controller;

import com.hz.gc.service.ProgressService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.vo.ProgressVo;
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

    @RequestMapping(value = "/findProgressList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<ProgressVo>> findProgressList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String itemProjectName
    ){
        List<ProgressVo> list = progressService.findProgressList(page,page_size,itemProjectName);
        Integer count = progressService.findProgressListCount(itemProjectName);

        JsonMassage<List<ProgressVo>> jsonMassage = new JsonMassage<List<ProgressVo>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }


/*    @RequestMapping(value = "/saveProgress",method = RequestMethod.POST)
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
    }*/
}
