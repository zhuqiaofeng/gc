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
@TableName("gc_admin")
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("管理员ID")
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    @ApiModelProperty("管理员账号")
    @TableField("admin_code")
    private String adminCode;

    @ApiModelProperty("管理员密码")
    @TableField("admint_password")
    private String admintPassword;

    @ApiModelProperty("管理员姓名")
    @TableField("admin_name")
    private String adminName;

    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("管理员手机号")
    @TableField("admin_phone")
    private String adminPhone;

    @ApiModelProperty("创建时间")
    @TableField("admin_create_time")
    private LocalDateTime adminCreateTime;

    @ApiModelProperty("创建人id,由超级管理员创建")
    @TableField("create_person_id")
    private Integer createPersonId;

    @ApiModelProperty("管理员最后一次登录ip")
    @TableField("admin_last_ip")
    private String adminLastIp;

    @ApiModelProperty("管理员最后一次登录时间")
    @TableField("admin_last_time")
    private LocalDateTime adminLastTime;

    @ApiModelProperty("管理员状态(0启用1禁用 默认0)")
    @TableField("admin_status")
    private Integer adminStatus;


}
