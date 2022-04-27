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
@TableName("gc_change")
@ApiModel(value = "Change对象", description = "")
public class Change implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime changeTime;

    @ApiModelProperty("变更内容:XX工程XXX部分XXX项进行改动为XXX")
    @TableField("changeContent")
    private String changeContent;


}
