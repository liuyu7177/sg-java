package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import com.liuyu7177.config.client.UserCenterClient;
import com.liuyu7177.data.pojo.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by liuyu7177 On 2019/10/29
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController extends BaseController {

    @Autowired
    private UserCenterClient userCenter;

    @GetMapping(path = "/userCenter/add")
    public JsonResult<String> addNewUser(@RequestParam(name = "name") String name) {
        return userCenter.add(name);
    }

    //测试获取全部的数据
    @GetMapping(path = "/userCenter/all")
    public JsonResult<Iterable<UserInfo>> getAllUsers() {
        return userCenter.getAllUsers();
    }

    //测试获取全部的数据
    @GetMapping(path = "/userCenter/alluser")
    @HystrixCommand(fallbackMethod = "defaultCallGetAllUser")
    public JsonResult<Iterable<UserInfo>> getAllUser() {
        return userCenter.getAllUsers();
    }

    public JsonResult<Iterable<UserInfo>> defaultCallGetAllUser() {
        return ApiError(COMMON_ERROR_MESSAGE,new ArrayList<UserInfo>());
    }
}
