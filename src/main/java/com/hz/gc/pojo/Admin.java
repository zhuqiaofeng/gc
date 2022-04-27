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
@TableName("gc_admin")
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("管理员ID")
    @TableId(value = "adminId", type = IdType.AUTO)
    private Integer adminId;

    @ApiModelProperty("管理员账号")
    @TableField("adminCode")
    private String adminCode;

    @ApiModelProperty("管理员密码")
    @TableField("admintPassword")
    private String admintPassword;

    @ApiModelProperty("管理员姓名")
    @TableField("adminName")
    private String adminName;

    @ApiModelProperty("角色ID")
    @TableField("roleId")
    private Integer roleId;

    @ApiModelProperty("管理员手机号")
    @TableField("adminPhone")
    private String adminPhone;

    @ApiModelProperty("创建时间")
    @TableField("adminCreateTime")
    private LocalDateTime adminCreateTime;

    @ApiModelProperty("创建人id,由超级管理员创建")
    @TableField("createPersonId")
    private Integer createPersonId;

    @ApiModelProperty("管理员最后一次登录ip")
    @TableField("adminLastIp")
    private String adminLastIp;

    @ApiModelProperty("管理员最后一次登录时间")
    @TableField("adminLastTime")
    private LocalDateTime adminLastTime;

    @ApiModelProperty("管理员状态(0启用1禁用 默认0)")
    @TableField("adminStatus")
    private Integer adminStatus;


}
