package com.hz.gc.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectUserVo {
    @ApiModelProperty("工程人员id")
    @TableId(value = "projectUserId", type = IdType.AUTO)
    private Integer projectUserId;

    @ApiModelProperty("总工程id")
    @TableField("totalProjectId")
    private Integer totalProjectId;

    @ApiModelProperty("用户id,员工ID，项目小组成员")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("工程人员信息描述")
    @TableField("projectUserDesc")
    private String projectUserDesc;


    @ApiModelProperty("工程名称")
    @TableField("totalProjectName")
    private String totalProjectName;

    @ApiModelProperty("工程描述")
    @TableField("totalProjectDesc")
    private String totalProjectDesc;

    @ApiModelProperty("工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("totalProjectState")
    private Integer totalProjectState;

    @ApiModelProperty("工程地址描述")
    @TableField("totalProjectAddress")
    private String totalProjectAddress;

    @ApiModelProperty("计划开始时间")
    @TableField("totalProjectStart")
    private String totalProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("totalProjectEnd")
    private String totalProjectEnd;

    @ApiModelProperty("总工期")
    @TableField("totalProjectDay")
    private Integer totalProjectDay;

    @ApiModelProperty("分部工程id")
    @TableId(value = "subProjectId", type = IdType.AUTO)
    private Integer subProjectId;

    @ApiModelProperty("分部工程名称")
    @TableField("subProjectName")
    private String subProjectName;

    @ApiModelProperty("分部工程描述")
    @TableField("subProjectDesc")
    private String subProjectDesc;

    @ApiModelProperty("分部工程计划开始时间")
    @TableField("subProjectStart")
    private LocalDateTime subProjectStart;

    @ApiModelProperty("分部工程计划结束时间")
    @TableField("subProjectEnd")
    private LocalDateTime subProjectEnd;

    @ApiModelProperty("分部工程工期")
    @TableField("subProjectDay")
    private Integer subProjectDay;

    @ApiModelProperty("分部工程施工区域描述")
    @TableField("subProjectRegion")
    private String subProjectRegion;

    @ApiModelProperty("分部工程负责人id（必须是工程人员信息表员工ID）")
    @TableField("subPranchUser")
    private Integer subPranchUser;

    @ApiModelProperty("分部工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("subProjectState")
    private Integer subProjectState;

    @ApiModelProperty("分项工程id")
    @TableId(value = "itemProjectId", type = IdType.AUTO)
    private Integer itemProjectId;

    @ApiModelProperty("分项工程名称")
    @TableField("itemProjectName")
    private String itemProjectName;

    @ApiModelProperty("分项工程描述")
    @TableField("itemProjectDesc")
    private String itemProjectDesc;

    @ApiModelProperty("分项工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("itemProjectState")
    private Integer itemProjectState;

    @ApiModelProperty("计划开始时间")
    @TableField("itemProjectStart")
    private LocalDateTime itemProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("itemProjectEnd")
    private LocalDateTime itemProjectEnd;

    @ApiModelProperty("分项工程工期")
    @TableField("itemProjectDay")
    private Integer itemProjectDay;



}
