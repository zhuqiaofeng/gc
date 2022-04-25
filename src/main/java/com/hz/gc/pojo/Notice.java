package com.hz.gc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("gc_notice")
@ApiModel(value = "Notice对象", description = "")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("公告id")
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    @ApiModelProperty("公告名称")
    @TableField("notice_name")
    private String noticeName;

    @ApiModelProperty("公告内容   HTML")
    @TableField("notice_content")
    private String noticeContent;

    @ApiModelProperty("发布时间，规则范文颁发时间")
    @TableField("notice_addtime")
    private LocalDateTime noticeAddtime;

    @ApiModelProperty("管理员id")
    @TableField("admin_id")
    private Integer adminId;


}
