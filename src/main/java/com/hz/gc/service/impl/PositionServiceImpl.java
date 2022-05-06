package com.hz.gc.service.impl;

import com.hz.gc.pojo.Position;
import com.hz.gc.dao.PositionDao;
import com.hz.gc.service.PositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionDao, Position> implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> findPositionList(Integer page, Integer page_size) {

        Integer pyl = (page-1)*page_size;

        return positionDao.findPositionList(pyl,page_size);
    }

    @Override
    public Integer findPositionListCount() {
        return positionDao.findPositionListCount();
    }

    @Override
    public int savePosition(Position position) {
        int i = positionDao.savePosition(position);
        return i;
    }

    @Override
    public int deletePositionById(Integer positionId ) {
        int i = positionDao.deletePositionById(positionId);
        return i;
    }

    @Override
    public int updatePosition(Position position) {
        int i = positionDao.updatePosition(position);

        return i;
    }

    @Override
    public Position findPositionById(Integer positionId) {
        return positionDao.findPositionById(positionId);
    }
}
