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
@TableName("gc_daily_progress")
@ApiModel(value = "DailyProgress对象", description = "")
public class DailyProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("每日进度id")
    @TableId(value = "daily_progress_id", type = IdType.AUTO)
    private Integer dailyProgressId;

    @ApiModelProperty("进度ID")
    @TableField("progress_id")
    private Integer progressId;

    @ApiModelProperty("每日进度描述")
    @TableField("daily_progress_desc")
    private String dailyProgressDesc;

    @ApiModelProperty("创建时间")
    @TableField("daily_progress_addtime")
    private LocalDateTime dailyProgressAddtime;

    @ApiModelProperty("填写人ID（必须是工程人员信息表ID）")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("分项工程ID待定")
    @TableField("item_project_id")
    private Integer itemProjectId;


}
