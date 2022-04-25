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
@TableName("gc_project_user")
@ApiModel(value = "ProjectUser对象", description = "")
public class ProjectUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("工程人员id")
    @TableId(value = "project_user_id", type = IdType.AUTO)
    private Integer projectUserId;

    @ApiModelProperty("总工程id")
    @TableField("total_project_id")
    private Integer totalProjectId;

    @ApiModelProperty("用户id,员工ID，项目小组成员")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("工程人员信息描述")
    @TableField("project_user_desc")
    private String projectUserDesc;


}
