package com.hz.gc.controller;

import com.hz.gc.pojo.Notice;
import com.hz.gc.service.NoticeService;
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
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "/findNoticeList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Notice>> findNoticeList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,

            String noticeName
            ){
        List<Notice> list = noticeService.findNoticeList(page, page_size, noticeName);
        Integer count = noticeService.findNoticeCount(noticeName);
        JsonMassage<List<Notice>>  jsonMassage = new JsonMassage<List<Notice>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
     }
    @RequestMapping(value = "/addNotice",method=RequestMethod.POST)
    @ResponseBody
    public ResultJson addNotice(Notice notice){
       int i = noticeService.addNotice(notice);
        return  new ResultJson(i);
    }

    @RequestMapping(value = "/delNotice",method=RequestMethod.POST)
    @ResponseBody
    public ResultJson  delNotice(Integer noticeId){
        int i = noticeService.delNotice(noticeId);
        return  new ResultJson(i);
    }
    @PostMapping(value = "/findNoticeById")
    public ResultJson<Notice> selectUserById(Integer noticeId){
        Notice notice = noticeService.findNoticeById(noticeId);
        return new ResultJson<Notice>(200,"成功",notice);
    }



}
