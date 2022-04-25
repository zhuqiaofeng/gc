package com.hz.gc.service;

import com.hz.gc.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface AdminService extends IService<Admin> {
   public int select();
   public int select2();

}
