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
public class DailyProgressUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("每日进度id")
    @TableId(value = "dailyProgressId", type = IdType.AUTO)
    private Integer dailyProgressId;

    @ApiModelProperty("进度ID")
    @TableField("progressId")
    private Integer progressId;

    @ApiModelProperty("填写人ID（必须是工程人员信息表ID）")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("每日进度描述")
    @TableField("dailyProgressDesc")
    private String dailyProgressDesc;

    @ApiModelProperty("工程实际开始时间")
    @TableField("progressActualStart")
    private String progressActualStart;

    @ApiModelProperty("工程实际开始结束")
    @TableField("progressActualEnd")
    private String progressActualEnd;

    @ApiModelProperty("创建时间")
    @TableField("dailyProgressAddtime")
    private String dailyProgressAddtime;

    @ApiModelProperty("分项工程ID待定")
    @TableField("itemProjectId")
    private Integer itemProjectId;

    @ApiModelProperty("用户名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty("分项工程名称")
    @TableField("itemProjectName")
    private String itemProjectName;
}
