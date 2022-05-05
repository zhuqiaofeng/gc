package com.hz.gc.service;

import com.hz.gc.pojo.Material;
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
public interface MaterialService extends IService<Material> {

    Material selectMaterialById(Integer materialId);

    /**
     * 分页+多条件模糊查询
     * @param curr_page 当前页
     * @param page_size 显示条数
     * @param materialDesc 资料说明
     * @param
     * @return
     */
    List<Material> findMaterialList(Integer curr_page, Integer page_size, String materialDesc);

    Integer findMaterialListCount(String materialDesc);

    /**
     * 上传资料
     * @param material
     * @return
     */
    int addMaterial(Material material);


    /**
     * 根据ID删除上传资料
     * @param materialId
     * @return
     */

    int deleteMaterialById(Integer materialId);
}
