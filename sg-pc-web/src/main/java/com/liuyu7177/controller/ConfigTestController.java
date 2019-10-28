package com.liuyu7177.controller;

import com.liuyu7177.config.SgPcWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libiyan on 2019/10/26.
 * @author  liuyu
 */
@RestController
public class ConfigTestController {
    @Autowired
    private Environment env;

    @GetMapping("/environment/config")
    public String environment() {
        return env.getProperty("sg.pc.web.name");
    }

    @Value("${sg.pc.web.name}")
    private String name;

    @GetMapping("/value/config")
    public String value() {
        return name;
    }

    @Autowired
    private SgPcWeb webValue;

    @GetMapping("/configuration/config")
    public String configuration() {
        return webValue.getName();
    }

}
