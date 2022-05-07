package com.hz.gc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttendanceVo {


    @ApiModelProperty("打卡id")
    @TableId(value = "attendanceId", type = IdType.AUTO)
    private Integer attendanceId;

    @ApiModelProperty("用户id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("打卡时间")
    @TableField("attendanceTime")
    private String attendanceTime;

    @ApiModelProperty("打卡地点")
    @TableField("attendanceAddress")
    private String attendanceAddress;

    @ApiModelProperty("打卡图片，URL")
    @TableField("attendanceImg")
    private String attendanceImg;


    @ApiModelProperty("用户名")
    @TableField("userName")
    private String userName;
}
