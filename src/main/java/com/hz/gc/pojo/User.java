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
@TableName("gc_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("性别：1男2女")
    @TableField("user_sex")
    private Integer userSex;

    @ApiModelProperty("用户手机号")
    @TableField("user_phone")
    private String userPhone;

    @ApiModelProperty("创建用户的管理员id")
    @TableField("admin_id")
    private Integer adminId;

    @ApiModelProperty("用户创建时间")
    @TableField("user_addtime")
    private LocalDateTime userAddtime;

    @ApiModelProperty("岗位id")
    @TableField("position_id")
    private Integer positionId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;


}
