package com.liuyu7177.config.client.fallaback;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.config.client.UserCenterClient;
import com.liuyu7177.data.pojo.UserInfo;
import org.springframework.stereotype.Component;

/**
 * Created by liuyu7177 On 2019/10/29
 */
@Component
public class UserCenterClientFallback implements UserCenterClient {
    @Override
    public JsonResult<String> add(String name) {
        return new JsonResult<String>(false,200,"UserCenterClientFallback");
    }

    @Override
    public JsonResult<Iterable<UserInfo>> getAllUsers() {
        return new JsonResult<Iterable<UserInfo>>(false,200,"UserCenterClientFallback",null);
    }
}
