package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import com.liuyu7177.config.client.UserCenterClient;
import com.liuyu7177.data.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonResult<Iterable<UserInfo>> getAllUsers() {
        return userCenter.getAllUsers();
    }

}
