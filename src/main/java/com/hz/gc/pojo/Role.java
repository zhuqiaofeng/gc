package com.hz.gc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
@TableName("gc_role")
@ApiModel(value = "Role对象", description = "")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableId(value = "roleId", type = IdType.AUTO)
    private Integer roleId;

    @ApiModelProperty("角色描述")
    @TableField("roleDesc")
    private String roleDesc;

    @ApiModelProperty("角色名称")
    @TableField("roleName")
    private String roleName;

    @ApiModelProperty("创建人id，由超级管理员创建")
    @TableField("adminId")
    private Integer adminId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty("创建时间")
    @TableField("roleCreateTime")
    private LocalDateTime roleCreateTime;

    @ApiModelProperty("角色状态(0启用1禁用 默认0)")
    @TableField("roleStatus")
    private Integer roleStatus;


}
