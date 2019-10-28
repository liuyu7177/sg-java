package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.liuyu7177.*"})
public class SgUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgUserCenterApplication.class, args);
    }

}
