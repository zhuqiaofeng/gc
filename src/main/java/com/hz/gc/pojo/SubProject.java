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
@TableName("gc_sub_project")
@ApiModel(value = "SubProject对象", description = "")
public class SubProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分部工程id")
    @TableId(value = "sub_project_id", type = IdType.AUTO)
    private Integer subProjectId;

    @ApiModelProperty("分部工程名称")
    @TableField("sub_project_name")
    private String subProjectName;

    @ApiModelProperty("分部工程描述")
    @TableField("sub_project_desc")
    private String subProjectDesc;

    @ApiModelProperty("分部工程计划开始时间")
    @TableField("sub_project_start")
    private LocalDateTime subProjectStart;

    @ApiModelProperty("分部工程计划结束时间")
    @TableField("sub_project_end")
    private LocalDateTime subProjectEnd;

    @ApiModelProperty("分部工程工期")
    @TableField("sub_project_day")
    private Integer subProjectDay;

    @ApiModelProperty("分部工程施工区域描述")
    @TableField("sub_project_region")
    private String subProjectRegion;

    @ApiModelProperty("分部工程负责人id（必须是工程人员信息表员工ID）")
    @TableField("sub_branch_user")
    private Integer subBranchUser;

    @ApiModelProperty("分部工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("sub_project_state")
    private Integer subProjectState;

    @ApiModelProperty("总工程id,确认该分部工程所属总工程")
    @TableField("total_project_id")
    private Integer totalProjectId;


}
