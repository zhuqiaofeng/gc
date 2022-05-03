package com.hz.gc.service.impl;

import com.hz.gc.dao.UserDao;
import com.hz.gc.pojo.Material;
import com.hz.gc.dao.MaterialDao;
import com.hz.gc.pojo.User;
import com.hz.gc.service.MaterialService;
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
public class MaterialServiceImpl extends ServiceImpl<MaterialDao, Material> implements MaterialService {

    @Autowired
    private MaterialDao materialDao;
    @Override
    public Material selectMaterialById(Integer materialId) {
        Material material = materialDao.selectMaterialById(materialId);
        return material;
    }

    @Override
    public List<Material> findMaterialList(Integer curr_page, Integer page_size, String materialDesc) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (curr_page-1)*page_size;

        List<Material> materials = materialDao.findMaterialList(pyl,page_size,materialDesc);
        return materials;
    }

    @Override
    public Integer findMaterialListCount(String materialDesc) {
        return materialDao.findMaterialListCount(materialDesc);
    }

    @Override
    public int addMaterial(Material material) {
        int i = materialDao.addMaterial(material);
        return i;
    }

    @Override
    public int deleteMaterialById(Integer materialId) {
        int i = materialDao.deleteMaterialById(materialId);
        return i;
    }


}
