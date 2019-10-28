package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import com.liuyu7177.data.pojo.UserInfo;
import com.liuyu7177.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by libiyan on 2019/10/27.
 *
 * @author liuyu
 */
@RestController
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(path = "/add")
    public JsonResult<String> addNewUser(@RequestParam String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfo= userInfoRepository.save(userInfo);
        return ApiSucceed(userInfo.toString());
    }

    //测试获取全部的数据
    @GetMapping(path = "/all")
    public Iterable<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }
}
