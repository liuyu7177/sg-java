package com.liuyu7177.controller;

import com.liuyu7177.config.JsonResult;
import com.liuyu7177.pojo.UserInfo;
import com.liuyu7177.config.client.UserCenterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by libiyan on 2019/10/27.
 * @author liuyu
 */
@RestController
public class UserCenterController extends BaseController {
    @Autowired
    private UserCenterClient userCenter;

    @GetMapping(path = "/userCenter/add")
    public JsonResult<String> addNewUser(@RequestParam(name = "name") String name) {
        return userCenter.add(name);
    }

    //测试获取全部的数据
    @GetMapping(path = "/userCenter/all")
    public ArrayList<UserInfo> getAllUsers() {
        return userCenter.getAllUsers();
    }

}
