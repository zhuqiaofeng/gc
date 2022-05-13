package com.hz.gc.controller;

import com.hz.gc.pojo.TotalProject;
import com.hz.gc.service.TotalProjectService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/totalProject")
public class TotalProjectController {


    @Autowired
    private TotalProjectService totalProjectService;

    /**
     * 分页模糊查询
     * @param page
     * @param page_size
     * @param totalProjectName
     * @param totalProjectDesc
     * @return
     */
    @RequestMapping(value = "/findTotalProjectList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<TotalProject>> findTotalProjectList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String totalProjectName,
            String totalProjectDesc
    ){
        List<TotalProject> list = totalProjectService.findTotalProjectList(page,page_size,totalProjectName,totalProjectDesc);
        Integer count = totalProjectService.findTotalProjectListCount(totalProjectName,totalProjectDesc);

        JsonMassage<List<TotalProject>> jsonMassage = new JsonMassage<List<TotalProject>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }


    /**
     * 新增
     * @param totalProject
     * @return
     */
    @RequestMapping(value = "/saveTotalProject",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson saveTotalProject(TotalProject totalProject){
        int i = totalProjectService.saveTotalProject(totalProject);
        return new ResultJson(i);
    }

    /**
     * 根据ID删除指定信息
     * @param totalProjectId
     * @return
     */
    @RequestMapping(value = "/deleteTotalProjectById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteTotalProjectById(Integer totalProjectId){
        int i = totalProjectService.deleteTotalProjectById(totalProjectId);
        return new ResultJson(i);
    }

    /**
     * 获取指定id信息
     * @param totalProjectId
     * @param model
     * @return
     */
    @RequestMapping(value = "/findTotalProjectById/{totalProjectId}")
    public String findTotalProjectById(@PathVariable("totalProjectId") Integer totalProjectId, Model model){

        model.addAttribute("totalProject",totalProjectService.findTotalProjectById(totalProjectId));
        return "project/total_project/total_project_edit.html";
    }

    /**
     * 更改
     * @param totalProject
     * @return
     */
    @RequestMapping(value = "/updateTotalProject",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateTotalProject(TotalProject totalProject){
        int i = totalProjectService.updateTotalProject(totalProject);
        return new ResultJson(i);
    }


    @RequestMapping(value = "/findTotalProjectNameList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<TotalProject>> findTotalProjectNameList(

    ){
        List<TotalProject> list = totalProjectService.findTotalProjectNameList();

        JsonMassage<List<TotalProject>> jsonMassage = new JsonMassage<List<TotalProject>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setData(list);
        return jsonMassage;
    }

}
