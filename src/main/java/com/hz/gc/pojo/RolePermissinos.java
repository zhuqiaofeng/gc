package com.hz.gc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("gc_role_permissinos")
@ApiModel(value = "RolePermissinos对象", description = "")
public class RolePermissinos implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色权现id")
    @TableId(value = "role_perm_id", type = IdType.AUTO)
    private Integer rolePermId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty("权现id")
    @TableField("perm_id")
    private Integer permId;


}
