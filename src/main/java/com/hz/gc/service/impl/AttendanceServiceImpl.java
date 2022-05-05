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

    /**
     * 通过ID查询信息
     * @param attendanceId
     * @return
     */
    @Override
    public Attendance selectAttendanceById(Integer attendanceId) {
        Attendance attendance = attendanceDao.selectAttendanceById(attendanceId);
        return attendance;
    }
    /**
     * 分页+多条件模糊查询
     * @param curr_page 当前页
     * @param page_size 显示条数
     * @param userName 用户名
     * @param
     * @return
     */
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
    /**
     * 添加打卡信息
     * @param attendance
     * @return
     */
    @Override
    public int addAttendance(Attendance attendance) {
        int i = attendanceDao.addAttendance(attendance);
        return i;
    }
}
