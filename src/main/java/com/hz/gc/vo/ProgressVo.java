package com.hz.gc.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;



/**
 * <p>
 *
 * </p>
 *
 * @author 第三组
 * @since 2022-05-06
 */
@Data
public class ProgressVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("进度id")
    @TableId(value = "progressId", type = IdType.AUTO)
    private Integer progressId;


    @ApiModelProperty("分项工程名称")
    @TableField("itemProjectName")
    private String itemProjectName;


    @ApiModelProperty("计划开始日期从分项计划中获取")
    @TableField("progressExpectedStater")
    private String progressExpectedStater;

    @ApiModelProperty("计划结束日期从分项计划中获取")
    @TableField("progressExpectedEnd")
    private String progressExpectedEnd;

    @ApiModelProperty("分项工程工期")
    @TableField("itemProjectDay")
    private Integer itemProjectDay;

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
