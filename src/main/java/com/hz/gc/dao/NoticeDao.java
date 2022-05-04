package com.hz.gc.dao;

import com.hz.gc.pojo.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * 公告管理  ljz
 * @author 第三组
 * @since 2022-04-23
 */
@Component
public interface NoticeDao extends BaseMapper<Notice> {
    /**
     *  查询所有公告信息：根据公告名称
     *
     *   noticeName   公告名称
     * @return
     */
    public List<Notice> findNoticeList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("noticeName") String noticeName
    );
    /**
     * 查询公告总记录条数
     */

    public  Integer findNoticeCount(
            @Param("noticeName") String noticeName
    );

    /**
     * 添加公告
     * @param notice
     * @return
     */
    public  int  addNotice(Notice notice);


    /**
     * 根据id删除公告
     * @param noticeId
     * @return
     */
   public int delNotice(Integer noticeId);

    /**
     * 通过id查询公告
     * @return
     */
    public Notice findNoticeById(Integer noticeId);


}
