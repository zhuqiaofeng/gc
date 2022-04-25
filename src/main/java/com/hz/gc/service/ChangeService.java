package com.hz.gc.service;

import com.hz.gc.pojo.Change;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface ChangeService extends IService<Change> {
    public int select();
    public int select3();
    public int select7();

}
