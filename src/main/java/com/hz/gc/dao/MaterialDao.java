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
    /**
     * 根据资料ID查询信息
     * @param materialId
     * @return
     */

    Material selectMaterialById(Integer materialId);

    /**
     * 根据资料说明查询信息
     * @param pyl 偏移量
     * @param page_size 当前页
     * @param materialDesc 资料说明
     * @return
     */
    List<Material> findMaterialList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("materialDesc")String materialDesc);


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

    int savePath(
           @Param("materialUrl") String path);
}
