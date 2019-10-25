package com.liuyu7177.sgeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liuyu
 */
@EnableEurekaServer
@SpringBootApplication
public class SgEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgEurekaServerApplication.class, args);
    }

}
