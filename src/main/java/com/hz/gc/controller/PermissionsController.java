/*
package com.hz.gc.controller;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.hz.gc.common.CommonResult;
import com.hz.gc.pojo.Permissions;
import com.hz.gc.pojo.Role;
import com.hz.gc.service.PermissionsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

*/
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 *//*

@RestController
@RequestMapping("/permissions")
public class PermissionsController {


    @Autowired
    private PermissionsService permissionsService;

    @ApiOperation("递归查询当前用户菜单")
    @GetMapping(value = "/menu")
    public CommonResult getPermissionMenuList(@RequestParam("userId") @ApiParam("用户id")Integer userId){
        List<Permissions> list = permissionsService.getPermissionListByUserId(userId);
        JSONArray parentMenu = new JSONArray();
        for (Permissions permission : list) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.putOnce("id", permission.getPermId().toString());
            jsonObject.putOnce("name", permission.getPermName());
            jsonObject.putOnce("icon", permission.getPermIcon());
            jsonObject.putOnce("info", "");

            JSONArray childMenu = new JSONArray();

            for (Permissions permission1 : permission.getChildren()) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.putOnce("id", permission1.getPermId().toString());
                jsonObject1.putOnce("name", permission1.getPermName());
                jsonObject1.putOnce("icon", permission1.getPermIcon());
                jsonObject1.putOnce("info","");
                jsonObject1.putOnce("url", permission1.getPermUrl());
                childMenu.put(jsonObject1);
            }
            jsonObject.putOnce("childList", childMenu);

            parentMenu.put(jsonObject);
        }
        return CommonResult.ok().data("data",parentMenu);
    }

    @ApiOperation("查询所有权限,无需分页")
    @GetMapping("/list")
    public CommonResult getPermissionList(){

        List<Permissions> data = permissionsService.list();
        System.out.println("data = " + data);
        return CommonResult.ok().data("data",data);
    }


    @ApiOperation("递归删除菜单")
    @PostMapping(value = "/deleteMenu")
    public CommonResult deleteMenuByPid(@RequestParam("id") @ApiParam("父级菜单id") Integer id){

        boolean flag = permissionsService.deleteMenuByPid(id);
        if (flag){
            return CommonResult.ok();
        }else{
            return CommonResult.error();
        }
    }

  */
/*  @ApiOperation("添加菜单栏")
    @PostMapping(value = "/saveMenu")
    public CommonResult saveMenu(@RequestBody @ApiParam("添加菜单的封装对象") Permission permission){
        permissionService.save(permission);
        return CommonResult.ok();
    }*//*


    @ApiOperation("为角色分配权限")
    @PostMapping(value = "/allot")
    public CommonResult forRoleAllotPermission(@RequestParam("roleId") @ApiParam("角色id") Integer roleId,
                                               @RequestParam("permIds") @ApiParam("分配的权限")List<Integer> permIds){

        boolean flag = permissionsService.forRoleAllotPermission(roleId,permIds);

        if (flag){
            return CommonResult.ok();
        }else{
            return CommonResult.error();
        }
    }
    */
/**
     *  简要说明: 管理员在权限模块能看到所有权限,勾选某个权限给角色进行分配,那么在勾选开始分配时,需要先回显出没有此权限的所有角色
     *  List<Long> permissionIds
     *//*


    @ApiOperation("分配权限时回显未拥有这些权限的角色")
    @GetMapping("/getWithOutPermissionTheRole")
    public CommonResult getWithOutPermissionTheRole(@RequestParam("permId") @ApiParam("分配的权限")Integer permId){

        List<Role> data = permissionsService.getWithOutPermissionTheRoles(permId);

        return CommonResult.ok().data("data",data);
    }

}
*/
