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

    List<Material> findMaterialList(Integer curr_page, Integer page_size, String materialDesc);

    Integer findMaterialListCount(String materialDesc);

    int addMaterial(Material material);

    int deleteMaterialById(Integer materialId);
}
