package com.hz.gc.controller;

import com.hz.gc.common.CommonResult;
import com.hz.gc.pojo.User;
import com.hz.gc.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping(value = "/findUserById")
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


}
