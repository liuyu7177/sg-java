package com.liuyu7177.controller;

import com.liuyu7177.common.config.JsonResult;
import com.liuyu7177.common.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libiyan on 2019/10/26.
 *
 * @author liuyu
 */
@RestController
public class JsonResultController extends BaseController {

    @GetMapping("/json/result")
    public JsonResult<String> jsonReult() {
        String a="f";
        return ApiSucceed("这里是JsonResult返回结果测试B");
    }
}
