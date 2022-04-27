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
@TableName("gc_permissions")
@ApiModel(value = "Permissions对象", description = "")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权现ID")
    @TableId(value = "permId", type = IdType.AUTO)
    private Integer permId;

    @ApiModelProperty("父级ID")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty("权限名称")
    @TableField("permName")
    private String permName;

    @ApiModelProperty("图标")
    @TableField("permIcon")
    private String permIcon;

    @ApiModelProperty("controller路径")
    @TableField("permUrl")
    private String permUrl;

    @ApiModelProperty("拥有哪些增删改查的权限")
    @TableField("permValue")
    private String permValue;

    @ApiModelProperty("权限类型0是菜单，1是按钮")
    @TableField("permType")
    private Integer permType;


}
