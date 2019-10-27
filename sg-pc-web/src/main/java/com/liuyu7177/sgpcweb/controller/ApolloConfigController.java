package com.liuyu7177.sgpcweb.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.liuyu7177.sgcommon.config.JsonResult;
import com.liuyu7177.sgcommon.controller.BaseController;
import com.liuyu7177.sgpcweb.config.ApolloDBConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libiyan on 2019/10/26.
 */
@RestController
public class ApolloConfigController extends BaseController {

    @Value("${apolloName:javaTest}")
    private String name;

    @Value("${env:env}")
    private String env;

    @Autowired
    private ApolloDBConfig dbConfig;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/apollo/env")
    public JsonResult<String> env(){
        return ApiSucceed(env);
    }

    @GetMapping("/apollo/dbConfig")
    public JsonResult<String> dbConfig(){
        ApolloDBConfig apolloDBConfig= context.getBean(ApolloDBConfig.class);
        return ApiSucceed(apolloDBConfig.toString());
    }

    @GetMapping("/apollo/apiConfig")
    public  String apiConfig(){
        Config config = ConfigService.getAppConfig();
         String someKey = "apolloName";
         String someDefaultValue = "apolloName";
         String value = config.getProperty(someKey, someDefaultValue);
         return  value;
    }

    @GetMapping("/apollo/envapiConfig")
    public  String envApiConfig(){
        return  name;
    }
}
