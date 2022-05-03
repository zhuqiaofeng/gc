package com.hz.gc.service.impl;

import com.hz.gc.dao.UserDao;
import com.hz.gc.pojo.Attendance;
import com.hz.gc.dao.AttendanceDao;
import com.hz.gc.pojo.User;
import com.hz.gc.service.AttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceDao, Attendance> implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public Attendance selectAttendanceById(Integer attendanceId) {
        Attendance attendance = attendanceDao.selectAttendanceById(attendanceId);
        return attendance;
    }

    @Override
    public List<Attendance> findAttendanceList(Integer curr_page, Integer page_size, String userName) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (curr_page-1)*page_size;

        List<Attendance> attendances = attendanceDao.findAttendanceList(pyl,page_size,userName);
        return attendances;
    }

    @Override
    public Integer findAttendanceListCount(String userName) {
        return attendanceDao.findAttendanceListCount(userName);
    }

    @Override
    public int addAttendance(Attendance attendance) {
        int i = attendanceDao.addAttendance(attendance);
        return i;
    }
}
