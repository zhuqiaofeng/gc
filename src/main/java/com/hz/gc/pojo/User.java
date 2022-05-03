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
import lombok.Data;
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
@TableName("gc_user")
@ApiModel(value = "User对象", description = "")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("userPassword")
    private String userPassword;

    @ApiModelProperty("性别：1男2女")
    @TableField("userSex")
    private Integer userSex;

    @ApiModelProperty("用户手机号")
    @TableField("userPhone")
    private String userPhone;

    @ApiModelProperty("创建用户的管理员id")
    @TableField("adminId")
    private Integer adminId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty("用户创建时间")
    @TableField("userAddtime")
    private LocalDateTime userAddtime;

    @ApiModelProperty("岗位id")
    @TableField("positionId")
    private Integer positionId;

    @ApiModelProperty("账号状态")
    @TableField("userStatus")
    private Integer userStatus;
}
