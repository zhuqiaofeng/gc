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
@TableName("gc_comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "commentId", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty("每日进度ID")
    @TableField("dailyProgressId")
    private Integer dailyProgressId;

    @ApiModelProperty("用户ID")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty("评论消息")
    @TableField("commentMsg")
    private String commentMsg;

    @ApiModelProperty("父级ID")
    @TableField("commParentId")
    private Integer commParentId;


}
