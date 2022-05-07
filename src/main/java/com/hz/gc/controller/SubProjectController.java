package com.hz.gc.controller;

import com.hz.gc.pojo.SubProject;
import com.hz.gc.service.SubProjectService;
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
@RequestMapping("/subProject")
public class SubProjectController {
    @Autowired
    private SubProjectService subProjectService;

    //多条件组合查询
    @RequestMapping(value = "/findSubProjectList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<SubProject>> findList(
            @RequestParam(value = "pyl",defaultValue = "1") Integer pyl,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String subProjectName,
            String subProjectDesc
    ){
        List<SubProject> list = subProjectService.findSubProjectList(pyl,page_size,subProjectName,subProjectDesc);
        Integer count = subProjectService.findSubProjectListCount(subProjectName,subProjectDesc);
        JsonMassage<List<SubProject>> jsonMassage = new JsonMassage<>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }
    //根据id删除
    @RequestMapping(value = "/deleteSubProjectrById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteSubProjectrById(Integer subProjectId){
        int i = subProjectService.deleteSubProjectById(subProjectId);
        return new ResultJson(i);
    }
    //修改
    @RequestMapping(value = "/updateSubProject",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateSubProjectr(SubProject subProject){
        int i = subProjectService.updateSubProject(subProject);
        return new ResultJson(i);
    }
//新增
    @RequestMapping(value = "/saveSubProject",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson saveProvider(SubProject subProject){
        int i = subProjectService.saveSubProject(subProject);
        return new ResultJson(i);
    }

    /**
     * 通过ID查询用户
     * @param subProjectId
     * @return
     */
    @RequestMapping(value = "/selectSubProjectById/{subProjectId}",method = RequestMethod.GET)
    public String selectSubProjectById(@PathVariable("subProjectId") Integer subProjectId, Model model){
        model.addAttribute("subProject",subProjectService.selectSubProjectById(subProjectId));
        return "project/sub_project/sub_edit";
    }
}
