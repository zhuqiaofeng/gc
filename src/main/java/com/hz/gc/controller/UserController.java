package com.hz.gc.controller;

import com.hz.gc.common.CommonResult;
import com.hz.gc.pojo.Comment;
import com.hz.gc.pojo.User;
import com.hz.gc.service.UserService;
import com.hz.gc.utils.JsonMassage;
import com.hz.gc.utils.ResultJson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/user")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页+多条件模糊查询
     * @param page 当前页
     * @param limit1 显示条数
     * @param userName 用户名
     * @param positionName 岗位名称
     * @return
     */
    @RequestMapping(value = "/findUserList",method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<User>> findUserList(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit1",defaultValue = "10") Integer limit1,
            String userName,
            String positionName
    ){
        List<User> list = userService.findUserList(page,limit1,userName,positionName);
        Integer count = userService.findUserListCount(userName,positionName);
        JsonMassage<List<User>> jsonMassage = new JsonMassage<List<User>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson addUser(User user){
        int i = userService.addUser(user);
        return new ResultJson(i);
    }

    /**
     * 通过ID查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/selectUserById/{userId}",method = RequestMethod.GET)
    public String selectUserById(@PathVariable("userId") Integer userId, Model model){
        model.addAttribute("user",userService.selectUserById(userId));
        return "user_edit";
    }

    /**
     * 删除指定ID的用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson deleteUserById(Integer userId){
        int i = userService.deleteUserById(userId);
        return new ResultJson(i);
    }

    /**
     * 修改指定ID的用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateUserById(@RequestBody User user){
        int i = userService.updateUserById(user);
        return new ResultJson(i);
    }















/*    @GetMapping(value = "/findUserById")
    public CommonResult queryUserById(@RequestParam("userId")@ApiParam("用户id") Integer userId){

        User user = userService.findUserById(userId);
        //System.out.println("user = " + user.toString());
        return CommonResult.ok().data("user",user);
    }

    @GetMapping(value = "/findUserList")
    public CommonResult queryUserQuery(){

        List<User> users = userService.findUserList();
        //System.out.println("user = " + user.toString());
        return CommonResult.ok().data("user",users);
    }

    @ApiOperation(value = "添加用户信息")
    @PostMapping(value = "/save")
    public CommonResult saveUser(@RequestBody @ApiParam("封装添加用户信息的对象") User user){

        boolean flag  = userService.saveUser(user);
        if (flag){
            return CommonResult.ok();
        }else {
            return CommonResult.error();
        }
    }

    @ApiOperation(value = "删除用户信息")
    @PostMapping(value = "/deleteById")
    public CommonResult deleteById(@RequestParam("userId") @ApiParam("用户id")Integer userId){
        boolean flag = userService.deleteUserById(userId);

        if (flag){
            return CommonResult.ok();
        }else {
            return CommonResult.error();
        }
    }


    @ApiOperation(value = "根据ID修改用户信息")
    @PostMapping(value = "/updateById")
    public CommonResult UpdateUserById(@RequestBody @ApiParam("封装添加用户信息的对象") User user){
        boolean flag = userService.updateById(user);

        if (flag){
            return CommonResult.ok();
        }else {
            return CommonResult.error();
        }
    }*/


}
