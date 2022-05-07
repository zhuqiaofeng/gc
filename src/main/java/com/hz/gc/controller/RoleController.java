package com.hz.gc.controller;

import com.hz.gc.pojo.Role;
import com.hz.gc.service.RoleService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    /**
     * 分页+多条件模糊查询
     * @param page 当前页
     * @param page_size 显示条数
     * @param roleName 角色名
     * @return
     */
    @RequestMapping(value = "/findRoleList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Role>> findRoleList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "page_size",defaultValue = "10") Integer page_size,
            String roleName
    ){
        List<Role> list = roleService.findRoleList(page,page_size,roleName);
        int count = roleService.findRoleListCount(roleName);
        JsonMassage<List<Role>> jsonMassage = new JsonMassage<List<Role>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }



    /**
     * 通过ID查询角色
     * @param roleId
     * @return
     */
    @RequestMapping("selectRoleById/{roleId}")
    public String selectRoleById(@PathVariable("roleId") Integer roleId, Model model){
    model.addAttribute(roleService.selectRoleById(roleId));
    return "admin/role/role_edit";
}


    /**
     * 修改指定ID的角色信息
     * @param role
     * @return
     */
    @RequestMapping(value = "/updateRole",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateRole(Role role){
        int i =roleService.updateRole(role);
        return new ResultJson(i);
    }


    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addRole(Role role){
        int i = roleService.addRole(role);
        return new ResultJson(i);
    }


    /**
     * 删除指定ID的角色信息
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/deleteRoleById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteRoleById(Integer roleId){
        int i = roleService.deleteRoleById(roleId);
        return new ResultJson(i);
    }

}
