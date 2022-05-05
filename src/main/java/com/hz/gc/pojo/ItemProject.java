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
@TableName("gc_item_project")
@ApiModel(value = "ItemProject对象", description = "")
public class ItemProject implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private String itemProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("itemProjectEnd")
    private String itemProjectEnd;

    @ApiModelProperty("分项工程工期")
    @TableField("itemProjectDay")
    private Integer itemProjectDay;

    @ApiModelProperty("分项工程负责人id（必须是工程人员信息表员工id）")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("分部工程id（确定该分项工程属于那个分部项目）")
    @TableField("subProjectId")
    private Integer subProjectId;


}
