package com.liuyu7177.config.client;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.data.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;

/**
 * Created by libiyan on 2019/10/27.
 * @author liuyu
 */
//@FeignClient(value = "${sg.user.service.name}")
@FeignClient(value = "sg-user-center")
public interface UserCenterClient {

    @GetMapping(path = "/add")
    public JsonResult<String> add(@RequestParam(name = "name") String name);

    //测试获取全部的数据
    @GetMapping(path = "/all")
    public ArrayList<UserInfo> getAllUsers();
}
