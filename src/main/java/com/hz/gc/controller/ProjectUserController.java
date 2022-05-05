package com.hz.gc.controller;

import com.hz.gc.pojo.ProjectUser;
import com.hz.gc.service.ProgressService;
import com.hz.gc.service.ProjectUserService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import com.hz.gc.vo.ProjectUserVo;
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
@RequestMapping("/projectUser")
public class ProjectUserController {

    @Autowired
    private ProjectUserService projectUserService;

    @RequestMapping(value = "addProjectUser")
    @ResponseBody
    public ResultJson addProjectUser(ProjectUser projectUser){
        int i =projectUserService.addProjectUser(projectUser);
        return new ResultJson(i);
    }

    @RequestMapping(value = "deleteProjectUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteProjectUser(Integer projectUserId){
         int i=projectUserService.deleteProjectUser(projectUserId);
        return new ResultJson(i);
    }

    @RequestMapping(value = "updateProjectUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateProjectUser(Integer projectUserId){
     int i= projectUserService.updateProjectUser(projectUserId);
        return new ResultJson(i);
    }


    @RequestMapping(value = "selectProjectUserList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<ProjectUserVo>> selectProjectUserList(
            @RequestParam(value = "pyl",defaultValue = "1") Integer pyl,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String totalProjectName,
            String userName

    ){
      List<ProjectUserVo>list  = projectUserService.selectProjectUserList(pyl, page_size, totalProjectName, userName);
      int concta =projectUserService.selectProjectUserListCount( totalProjectName, userName);
        JsonMassage<List<ProjectUserVo>> jsonMassage=new JsonMassage<List<ProjectUserVo>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(concta);
        jsonMassage.setData(list);
        return jsonMassage;
    }

}
