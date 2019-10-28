package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liuyu7177.config.client")
@SpringBootApplication
public class SgPcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgPcWebApplication.class, args);
    }

}
