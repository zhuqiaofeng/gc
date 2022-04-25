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
@TableName("gc_progress")
@ApiModel(value = "Progress对象", description = "")
public class Progress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("进度id")
    @TableId(value = "progress_id", type = IdType.AUTO)
    private Integer progressId;

    @ApiModelProperty("分项工程id，从分项计划中获取")
    @TableField("item_project_id")
    private Integer itemProjectId;

    @ApiModelProperty("计划开始日期从分项计划中获取")
    @TableField("progress_expected_stater")
    private LocalDateTime progressExpectedStater;

    @ApiModelProperty("计划结束日期从分项计划中获取")
    @TableField("progress_expected_end")
    private LocalDateTime progressExpectedEnd;

    @ApiModelProperty("实际开始日期")
    @TableField("progress_actual_start")
    private LocalDateTime progressActualStart;

    @ApiModelProperty("实际结束日期")
    @TableField("progress_actual_end")
    private LocalDateTime progressActualEnd;

    @ApiModelProperty("已持续天数从开始时间到当前时间  自动更新？")
    @TableField("progress_day")
    private Integer progressDay;

    @ApiModelProperty("用户ID  上传进度信息的那个用户ID")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("进度统计说明")
    @TableField("progress_desc")
    private String progressDesc;


}
