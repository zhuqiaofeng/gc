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
@TableName("gc_system")
@ApiModel(value = "System对象", description = "")
public class System implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("系统ID")
    @TableId(value = "system_id", type = IdType.AUTO)
    private Integer systemId;

    @ApiModelProperty("系统名称")
    @TableField("system_name")
    private String systemName;

    @ApiModelProperty("域名")
    @TableField("system_dns")
    private String systemDns;

    @ApiModelProperty("备案号")
    @TableField("system_emc")
    private String systemEmc;


}
