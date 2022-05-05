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
import java.time.LocalDateTime;

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
@TableName("gc_progress")
@ApiModel(value = "Progress对象", description = "")
public class Progress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("进度id")
    @TableId(value = "progressId", type = IdType.AUTO)
    private Integer progressId;

    @ApiModelProperty("分项工程id，从分项计划中获取")
    @TableField("itemProjectId")
    private Integer itemProjectId;

    @ApiModelProperty("计划开始日期从分项计划中获取")
    @TableField("progressExpectedStater")
    private String progressExpectedStater;

    @ApiModelProperty("计划结束日期从分项计划中获取")
    @TableField("progressExpectedEnd")
    private String progressExpectedEnd;

    @ApiModelProperty("实际开始日期")
    @TableField("progressActualStart")
    private String  progressActualStart;

    @ApiModelProperty("实际结束日期")
    @TableField("progressActualEnd")
    private String progressActualEnd;

    @ApiModelProperty("已持续天数从开始时间到当前时间  自动更新？")
    @TableField("progressDay")
    private Integer progressDay;



}
