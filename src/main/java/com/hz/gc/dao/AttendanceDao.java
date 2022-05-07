package com.hz.gc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.gc.pojo.Attendance;
import com.hz.gc.vo.AttendanceVo;
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
    /**
     * 通过ID查询信息
     * @param attendanceId
     * @return
     */
    Attendance selectAttendanceById(Integer attendanceId);
    /**
     * 分页+多条件模糊查询
     * @param pyl 当前页
     * @param page_size 显示条数
     * @param userName 用户名
     * @param
     * @return
     */
    List<AttendanceVo> findAttendanceList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("userName") String userName);

    Integer findAttendanceListCount(
            String userName);
    /**
     * 添加打卡信息
     * @param attendance
     * @return
     */
    int addAttendance(Attendance attendance);
}
