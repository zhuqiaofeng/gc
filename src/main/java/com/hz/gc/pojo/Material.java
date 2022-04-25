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
@TableName("gc_material")
@ApiModel(value = "Material对象", description = "")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("资料ID")
    @TableId(value = "material_id", type = IdType.AUTO)
    private Integer materialId;

    @ApiModelProperty("路径(图片或文件)url")
    @TableField("material_url")
    private String materialUrl;

    @ApiModelProperty("资料说明")
    @TableField("material_desc")
    private String materialDesc;

    @ApiModelProperty("所属每日进度ID")
    @TableField("daily_progress_id")
    private Integer dailyProgressId;


}
