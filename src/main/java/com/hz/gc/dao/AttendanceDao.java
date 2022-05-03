package com.hz.gc.dao;

import com.hz.gc.pojo.Attendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Component
public interface AttendanceDao extends BaseMapper<Attendance> {

    Attendance selectAttendanceById(Integer attendanceId);

    List<Attendance> findAttendanceList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("userName") String userName);

    Integer findAttendanceListCount(
            String userName);

    int addAttendance(Attendance attendance);
}
