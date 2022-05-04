package com.hz.gc.service.impl;

import com.hz.gc.pojo.Change;
import com.hz.gc.dao.ChangeDao;
import com.hz.gc.service.ChangeService;
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
public class ChangeServiceImpl extends ServiceImpl<ChangeDao, Change> implements ChangeService {
    @Autowired
    private  ChangeDao changeDao;


    @Override
    public int addChange(Change change) {
        int i = changeDao.addChange(change);
        return i;
    }

    @Override
    public List<Change> findChangeList(Integer page, Integer page_size, String changeContent, String userName) {
        //计算偏移量= （当前页-1）*page_size;
        Integer pyl =(page-1)*page_size;
        return changeDao.findChangeList(pyl,page_size,changeContent,userName);
    }

    @Override
    public Integer findChangeCount(String changeContent, String userName) {
        return changeDao.findChangeCount(changeContent,userName);
    }
}
