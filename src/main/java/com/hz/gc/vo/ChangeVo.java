package com.hz.gc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangeVo {

    @ApiModelProperty("分项工程名称")
    @TableField("itemProjectName")
    private String itemProjectName;

    @ApiModelProperty("用户名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty("变更记录ID")
    @TableId(value = "changeId", type = IdType.AUTO)
    private Integer changeId;

    @ApiModelProperty("工程id")
    @TableField("itemProjectId")
    private Integer itemProjectId;

    @ApiModelProperty("变更人ID,用户id")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("变更时间")
    @TableField("changeTime")
    private String changeTime;

    @ApiModelProperty("变更内容:XX工程XXX部分XXX项进行改动为XXX")
    @TableField("changeContent")
    private String changeContent;
}
