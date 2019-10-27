package com.liuyu7177.sgpcweb.controller;

import com.liuyu7177.sgcommon.config.JsonResult;
import com.liuyu7177.sgcommon.controller.BaseController;
import com.liuyu7177.sgdata.pojo.UserInfo;
import com.liuyu7177.sgpcweb.config.client.UserCenterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

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
