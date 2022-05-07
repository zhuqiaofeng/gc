package com.hz.gc.dao;

import com.hz.gc.pojo.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface PositionDao extends BaseMapper<Position> {

    List<Position> findPositionList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size
    );

    Integer findPositionListCount();

    int savePosition(Position position);

    int deletePositionById(Integer positionId);

    int updatePosition(Position position);

    Position findPositionById(Integer positionId);
}
