package com.hz.gc.service;

import com.hz.gc.pojo.Position;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface PositionService extends IService<Position> {

    List<Position> findPositionList(Integer page, Integer page_size);

    Integer findPositionListCount();

    int savePosition(Position position);

    int deletePositionById(Integer positionId);

    int updatePosition(Position position);

    Position findPositionById(Integer positionId);
}
