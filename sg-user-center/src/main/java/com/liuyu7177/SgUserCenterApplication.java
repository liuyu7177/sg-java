package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.liuyu7177.sgdata")
public class SgUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgUserCenterApplication.class, args);
    }

}
