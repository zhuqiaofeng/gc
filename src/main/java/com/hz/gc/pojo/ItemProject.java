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
@TableName("gc_item_project")
@ApiModel(value = "ItemProject对象", description = "")
public class ItemProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分项工程id")
    @TableId(value = "item_project_id", type = IdType.AUTO)
    private Integer itemProjectId;

    @ApiModelProperty("分项工程名称")
    @TableField("item_project_name")
    private String itemProjectName;

    @ApiModelProperty("分项工程描述")
    @TableField("item_project_desc")
    private String itemProjectDesc;

    @ApiModelProperty("分项工程状态（1未开工2在建3停工4完工5逾期）默认未开工")
    @TableField("item_project_state")
    private Integer itemProjectState;

    @ApiModelProperty("计划开始时间")
    @TableField("item_project_start")
    private LocalDateTime itemProjectStart;

    @ApiModelProperty("计划结束时间")
    @TableField("item_project_end")
    private LocalDateTime itemProjectEnd;

    @ApiModelProperty("分项工程工期")
    @TableField("item_project_day")
    private Integer itemProjectDay;

    @ApiModelProperty("分项工程负责人id（必须是工程人员信息表员工id）")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("分部工程id（确定该分项工程属于那个分部项目）")
    @TableField("sub_project_id")
    private Integer subProjectId;


}
