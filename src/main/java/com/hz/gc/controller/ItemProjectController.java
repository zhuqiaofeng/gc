package com.hz.gc.controller;

import com.hz.gc.pojo.ItemProject;
import com.hz.gc.service.ItemProjectService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import com.hz.gc.vo.itemVo;
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
@RequestMapping("/itemProject")
public class ItemProjectController {
    @Autowired
    private ItemProjectService itemProjectService;
    //新增j
    @RequestMapping(value = "/saveItemProject",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson saveItemProject(ItemProject itemProject){
        int i = itemProjectService.saveItemProject(itemProject);
        return new ResultJson(i);
    }
    //删除
    @RequestMapping(value = "/deleteItemProjectById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteItemProjectById(Integer subProjectId){
        System.out.println("hhhh");
        int i = itemProjectService.deleteItemProjectById(subProjectId);
        return new ResultJson(i);
    }


     //修改指定ID的用户信息

    @RequestMapping(value = "/updateItemProjectById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateUserById( ItemProject itemProject){
        int i = itemProjectService.updateItemProjectById(itemProject);
        return new ResultJson(i);
    }
    //根据id查询信息
    @RequestMapping(value = "/findItemProjectById/{itemProjectId}",method = RequestMethod.GET)
    public String findItemProjectById(@PathVariable("itemProjectId") Integer itemProjectId, Model model){
        model.addAttribute("pro",itemProjectService.findItemProjectById(itemProjectId));
        return "project/item_project/item_edit";
    }
    /**
     * 分页+多条件模糊查询
     * @param pyl 当前页
     * @param pyl 显示条数
     * @param itemProjectName 用户名
     * @param itemProjectDesc 描述
     * @return
     */
    @RequestMapping(value = "/findItemProjectList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<itemVo>> finditemProjectList(
            @RequestParam(value = "pyl",defaultValue = "1") Integer pyl,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String itemProjectName,
            String itemProjectDesc

    ){
        List<itemVo> list = itemProjectService.finditemProjectList(pyl,page_size,itemProjectName,itemProjectDesc);
        Integer count = itemProjectService.finditemProjectListCount(itemProjectName,itemProjectDesc);
        JsonMassage<List<itemVo>> jsonMassage = new JsonMassage<List<itemVo>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }
}
