package com.hz.gc.controller;

import com.hz.gc.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/projectUser")
public class ProjectUserController {

    @Autowired
    private ProjectUserService projectUserService;






}
