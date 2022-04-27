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
@TableName("gc_material")
@ApiModel(value = "Material对象", description = "")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("资料ID")
    @TableId(value = "materialId", type = IdType.AUTO)
    private Integer materialId;

    @ApiModelProperty("路径(图片或文件)url")
    @TableField("materialUrl")
    private String materialUrl;

    @ApiModelProperty("资料说明")
    @TableField("materialDesc")
    private String materialDesc;

    @ApiModelProperty("所属每日进度ID")
    @TableField("dailyProgressId")
    private Integer dailyProgressId;


}
