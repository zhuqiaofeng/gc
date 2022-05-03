package com.hz.gc.service;

import com.hz.gc.pojo.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;

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

    Attendance selectAttendanceById(Integer attendanceId);


    List<Attendance> findAttendanceList(Integer curr_page, Integer page_size, String userName);

    Integer findAttendanceListCount(String userName);

    int addAttendance(Attendance attendance);
}
