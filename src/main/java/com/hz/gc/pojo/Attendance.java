package com.hz.gc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Getter
@Setter
@TableName("gc_attendance")
@ApiModel(value = "Attendance对象", description = "")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("打卡id")
    @TableId(value = "attendance_id", type = IdType.AUTO)
    private Integer attendanceId;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("打卡时间")
    @TableField("attendance_time")
    private LocalDateTime attendanceTime;

    @ApiModelProperty("打卡地点")
    @TableField("attendance_address")
    private String attendanceAddress;

    @ApiModelProperty("打卡图片，URL")
    @TableField("attendance_img")
    private String attendanceImg;


}
