package com.hz.gc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 第三组
 * @since 2022-04-27
 */
@Getter
@Setter
@TableName("gc_attendance")
@ApiModel(value = "Attendance对象", description = "")
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

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


}
