package com.hz.gc.controller;


import com.hz.gc.pojo.Change;
import com.hz.gc.service.ChangeService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import com.hz.gc.vo.ChangeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author 第三组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/change")
public class ChangeController {
    @Autowired
    private ChangeService changeService;
    @RequestMapping(value = "/addChange",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addChange(Change change){
      int i = changeService.addChange(change);
        return new ResultJson(i);
    };

   @RequestMapping(value = "/findChangeList",method = RequestMethod.GET)
   @ResponseBody
    public JsonMassage<List<ChangeVo>> findChangeList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String changeContent,
            String userName
    ){
       List<ChangeVo> changeList = changeService.findChangeList(page, page_size, changeContent, userName);
       Integer count = changeService.findChangeCount(changeContent, userName);
//       Integer changeCount= 0;
//       if (changeContent!=null){
//           changeCount= changeService.findChangeCount(changeContent, userName);
//       }
      //
       JsonMassage<List<ChangeVo>> jsonMassage = new  JsonMassage<List<ChangeVo>>();
       jsonMassage.setCode(0);
       jsonMassage.setMsg("请求成功");
       jsonMassage.setCount(count);
       jsonMassage.setData(changeList);
       return jsonMassage;
        /* //条件构造器
       QueryWrapper<Change> queryWrapper = new QueryWrapper<>();
       if(changeContent!=null){
           queryWrapper.like("changeContent",changeContent);
       }
       //分页工具
       Page<Change> page1 = new Page<Change>(page,page_size);
       //调用service下的分页方法
       Page<Change> page2 = changeService.page(page1, queryWrapper);

       JsonMassage<List<Change>> jsonMassage = new  JsonMassage<List<Change>>();
       jsonMassage.setCode(0);
       jsonMassage.setMsg("请求成功");
       jsonMassage.setCount(Math.toIntExact(page1.getTotal()));
       jsonMassage.setData(page2.getRecords());
       return jsonMassage;*/
    }

}
