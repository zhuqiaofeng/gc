package com.hz.gc.service.impl;

import com.hz.gc.pojo.Notice;
import com.hz.gc.dao.NoticeDao;
import com.hz.gc.service.NoticeService;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {
    @Autowired
    private  NoticeDao noticeDao;

    @Override
    public List<Notice> findNoticeList(Integer page, Integer page_size,String noticeName) {
        //计算偏移量= （当前页-1）*page_size;
        Integer pyl =(page-1)*page_size;

        return noticeDao.findNoticeList(pyl,page_size,noticeName);
    }

    @Override
    public Integer findNoticeCount(String noticeName) {
        return noticeDao.findNoticeCount(noticeName);
    }

    @Override
    public int addNotice(Notice notice) {
        int i = noticeDao.addNotice(notice);
        return i;
    }

    @Override
    public int delNotice(Integer noticeId) {
        int i =noticeDao.delNotice(noticeId);
        return  i;
    }

    @Override
    public Notice findNoticeById(Integer noticeId) {
        return noticeDao.findNoticeById(noticeId);
    }
}
