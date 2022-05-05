package com.hz.gc.service;

import com.hz.gc.pojo.Change;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ChangeService extends IService<Change> {
    /**
     *  新增变更记录
     * @param change
     * @return
     */
    public  int addChange(Change change);
    /**
     * 分页查询  根据用户名和分项工程
     *  @param  changeContent 变更内容
     *  @param  userName      用户姓名
     *  @return
     */
    public List<Change> findChangeList(
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
