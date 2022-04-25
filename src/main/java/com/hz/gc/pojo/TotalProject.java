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
@TableName("gc_total_project")
@ApiModel(value = "TotalProject对象", description = "")
public class TotalProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("总工程id")
    @TableId(value = "total_project_id", type = IdType.AUTO)
    private Integer totalProjectId;

    @ApiModelProperty("工程名称")
    @TableField("total_project_name")
    private String totalProjectName;

    @ApiModelProperty("工程描述")
    @TableField("total_project_desc")
    private String totalProjectDesc;

    @ApiModelProperty("工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("total_project_state")
    private Integer totalProjectState;

    @ApiModelProperty("工程地址描述")
    @TableField("total_project_address")
    private String totalProjectAddress;

    @ApiModelProperty("计划开始时间")
    @TableField("total_project_start")
    private LocalDateTime totalProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("total_project_end")
    private LocalDateTime totalProjectEnd;

    @ApiModelProperty("总工期")
    @TableField("total_project_day")
    private Integer totalProjectDay;

    @ApiModelProperty("工程地址X坐标")
    @TableField("total_project_address_X")
    private String totalProjectAddressX;

    @ApiModelProperty("工程地址Y坐标")
    @TableField("total_project_address_Y")
    private String totalProjectAddressY;


}
