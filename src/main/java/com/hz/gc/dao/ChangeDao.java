package com.hz.gc.dao;

import com.hz.gc.pojo.Change;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *  变更记录  ljz
 * @author 第三组
 * @since 2022-04-23
 */
public interface ChangeDao extends BaseMapper<Change> {
    /**
     * 新增变更记录
     */
    public int addChange(Change change);

    /**
     *
     * @param pyl
     * @param page_size
     * @param changeContent
     * @param userName
     * @return
     */
    public List<Change>  findChangeList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("changeContent") String changeContent,
            @Param("userName") String userName
    );

    /**
     * 记录总条数
     * @param
     * @return
     */
    public  Integer findChangeCount(
            @Param("changeContent") String changeContent,
            @Param("userName") String userName
    );

}
