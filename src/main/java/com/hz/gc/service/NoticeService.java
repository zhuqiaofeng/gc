package com.hz.gc.service;

import com.hz.gc.pojo.Notice;
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
public interface NoticeService extends IService<Notice> {

    //查询所有用户的信息
    public List<Notice> findNoticeList(
            Integer curr_page,
            Integer page_size,
            String noticeName
    );
    // 查询用户的总记录条数
    public  Integer findNoticeCount(
            String noticeName
    );

    /**
     * 添加公告
     * @param
     * @return
     */
    public int addNotice(Notice notice);

    /**
     * 根据id删除公告
     * @param noticeId
     * @return
     */
    public int delNotice(Integer noticeId);

    public Notice findNoticeById(Integer noticeId);

}
