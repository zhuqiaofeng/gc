package com.hz.gc.controller;

import com.hz.gc.pojo.Attendance;
import com.hz.gc.pojo.Material;
import com.hz.gc.pojo.User;
import com.hz.gc.service.MaterialService;
import com.hz.gc.service.UserService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /**
     * 根据ID删除上传资料
     * @param materialId
     * @return
     */
    @RequestMapping(value = "/deleteMaterialById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteMaterialById(Integer materialId){
        int i = materialService.deleteMaterialById(materialId);
        return new ResultJson(i);
    }

    /**
     * 上传资料
     * @param material
     * @return
     */
    @RequestMapping(value = "/addMaterial",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addMaterial(Material material){
        int i = materialService.addMaterial(material);
        return new ResultJson(i);
    }


    /**
     * 分页+多条件模糊查询
     * @param page 当前页
     * @param limit1 显示条数
     * @param materialDesc 资料说明
     * @param
     * @return
     */
    @RequestMapping(value = "/findMaterialList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Material>> findAttendanceList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit1",defaultValue = "10") Integer limit1,
            String materialDesc
    ){
        List<Material> list = materialService.findMaterialList(page,limit1,materialDesc);
        Integer count = materialService.findMaterialListCount(materialDesc);
        JsonMassage<List<Material>> jsonMassage = new JsonMassage<List<Material>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }
    /**
     * 通过资料ID查询信息
     * @param materialId
     * @return
     */
    @PostMapping(value = "/selectMaterialById")
    public ResultJson<Material> selectMaterialById(Integer materialId){
        Material material = materialService.selectMaterialById(materialId);
        return new ResultJson<Material>(200,"成功",material);
    }

}
