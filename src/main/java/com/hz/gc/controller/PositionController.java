package com.hz.gc.controller;

import com.hz.gc.pojo.Position;
import com.hz.gc.service.PositionService;
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
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/findPositionList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Position>> findPositionList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size
    ){
        List<Position> list = positionService.findPositionList(page,page_size);
        Integer count = positionService.findPositionListCount();

        JsonMassage<List<Position>> jsonMassage = new JsonMassage<List<Position>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    @RequestMapping(value = "/savePosition",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson savePosition( Position position){
       int i = positionService.savePosition(position);
        return new ResultJson(i);
    }

    @RequestMapping(value = "/deletePosition",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deletePositionById(Integer positionId){
        int i = positionService.deletePositionById(positionId);
        return new ResultJson(i);
    }

    @RequestMapping(value = "/findPositionById/{positionId}",method = RequestMethod.GET)
    public String findPositionById(@PathVariable("positionId") Integer positionId, Model model){
        model.addAttribute("position",positionService.findPositionById(positionId));
        return "admin/position/position_edit";
    }

    @RequestMapping(value = "/updatePosition",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updatePosition( Position position){
        int i = positionService.updatePosition(position);
        return new ResultJson(i);
    }
}
