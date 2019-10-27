package com.liuyu7177.sgpcweb.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by libiyan on 2019/10/26.
 */
@ConfigurationProperties(prefix = "sg.pc.web")
@Component
@Data
public class SgPcWeb {
    private String name;
}
