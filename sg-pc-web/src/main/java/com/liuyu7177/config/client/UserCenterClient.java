package com.liuyu7177.config.client;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.config.client.fallaback.UserCenterClientFallback;
import com.liuyu7177.data.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by libiyan on 2019/10/27.
 * @author liuyu
 */
@FeignClient(value = "${sg.user.service.name}",fallback = UserCenterClientFallback.class)
@Component
public interface UserCenterClient {

    @GetMapping(path = "/add")
    public JsonResult<String> add(@RequestParam(name = "name") String name);

    //测试获取全部的数据
    @GetMapping(path = "/all")
    public JsonResult<Iterable<UserInfo>> getAllUsers();
}
