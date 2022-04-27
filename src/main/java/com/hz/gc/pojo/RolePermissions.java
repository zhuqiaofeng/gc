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
@TableName("gc_role_permissions")
@ApiModel(value = "RolePermissions对象", description = "")
public class RolePermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色权现id")
    @TableId(value = "rolePermId", type = IdType.AUTO)
    private Integer rolePermId;

    @ApiModelProperty("角色id")
    @TableField("roleId")
    private Integer roleId;

    @ApiModelProperty("权现id")
    @TableField("permId")
    private Integer permId;


}
