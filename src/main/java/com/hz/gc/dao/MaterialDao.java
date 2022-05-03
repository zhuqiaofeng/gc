package com.hz.gc.dao;

import com.hz.gc.pojo.Material;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
public interface MaterialDao extends BaseMapper<Material> {

    Material selectMaterialById(Integer materialId);

    List<Material> findMaterialList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("materialDesc")String materialDesc);

    Integer findMaterialListCount(String materialDesc);

    int addMaterial(Material material);

    int deleteMaterialById(Integer materialId);
}
