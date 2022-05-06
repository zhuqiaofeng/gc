package com.hz.gc.controller;

import com.hz.gc.pojo.Attendance;
import com.hz.gc.pojo.User;
import com.hz.gc.service.AttendanceService;
import com.hz.gc.service.UserService;
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
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 添加打卡信息
     * @param attendance
     * @return
     */
    @RequestMapping(value = "/addAttendance",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addAttendance(@RequestBody Attendance attendance){
        int i = attendanceService.addAttendance(attendance);
        return new ResultJson(i);
    }


    /**
     * 分页+多条件模糊查询
     * @param page 当前页
     * @param limit1 显示条数
     * @param userName 用户名
     * @param
     * @return
     */
    @RequestMapping(value = "/findAttendanceList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Attendance>> findAttendanceList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit1",defaultValue = "10") Integer limit1,
            String userName
    ){
        List<Attendance> list = attendanceService.findAttendanceList(page,limit1,userName);

        Integer count = attendanceService.findAttendanceListCount(userName);

        JsonMassage<List<Attendance>> jsonMassage = new JsonMassage<List<Attendance>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }


    /**
     * 通过ID查询信息
     * @param attendanceId
     * @return
     */
    @PostMapping(value = "/selectAttendanceById")
    public ResultJson<Attendance> selectAttendanceById(Integer attendanceId){
        Attendance attendance = attendanceService.selectAttendanceById(attendanceId);
        return new ResultJson<Attendance>(200,"成功",attendance);
    }

}
