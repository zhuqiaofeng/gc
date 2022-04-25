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
@TableName("gc_permissinos")
@ApiModel(value = "Permissinos对象", description = "")
public class Permissinos implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权现ID")
    @TableId(value = "perm_id", type = IdType.AUTO)
    private Integer permId;

    @ApiModelProperty("权限名称")
    @TableField("perm_name")
    private String permName;

    @ApiModelProperty("图标")
    @TableField("perm_icon")
    private String permIcon;

    @ApiModelProperty("controller路径")
    @TableField("perm_url")
    private String permUrl;

    @ApiModelProperty("父级ID")
    @TableField("parent_id")
    private Integer parentId;


}
