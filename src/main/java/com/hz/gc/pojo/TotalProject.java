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
@TableName("gc_total_project")
@ApiModel(value = "TotalProject对象", description = "")
public class TotalProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("总工程id")
    @TableId(value = "totalProjectId", type = IdType.AUTO)
    private Integer totalProjectId;

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
    private LocalDateTime totalProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("totalProjectEnd")
    private LocalDateTime totalProjectEnd;

    @ApiModelProperty("总工期")
    @TableField("totalProjectDay")
    private Integer totalProjectDay;

    @ApiModelProperty("工程地址X坐标")
    @TableField("totalProjectAddressX")
    private String totalProjectAddressX;

    @ApiModelProperty("工程地址Y坐标")
    @TableField("totalProjectAddressY")
    private String totalProjectAddressY;


}
