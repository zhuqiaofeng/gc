package com.hz.gc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.gc.pojo.Attendance;
import com.hz.gc.vo.AttendanceVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface AttendanceService extends IService<Attendance> {

    /**
     * 通过ID查询信息
     * @param attendanceId
     * @return
     */
    Attendance selectAttendanceById(Integer attendanceId);
    /**
     * 分页+多条件模糊查询
     * @param curr_page 当前页
     * @param page_size 显示条数
     * @param userName 用户名
     * @param
     * @return
     */

    List<AttendanceVo> findAttendanceList(Integer curr_page, Integer page_size, String userName);

    Integer findAttendanceListCount(String userName);

    /**
     * 添加打卡信息
     * @param attendance
     * @return
     */
    int addAttendance(Attendance attendance);
}
