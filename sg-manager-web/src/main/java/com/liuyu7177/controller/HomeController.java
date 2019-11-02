package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by libiyan on 2019/11/2.
 * @author liuyu
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    @GetMapping(path = "/index")
    public String index() {
        return "home/Index";
    }

    @GetMapping("/json/result")
    public JsonResult<String> jsonReult() {
        String a="f";
        return ApiSucceed("这里是JsonResult返回结果测试B");
    }
}
