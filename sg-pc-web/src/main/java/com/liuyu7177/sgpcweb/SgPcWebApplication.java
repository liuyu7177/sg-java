package com.liuyu7177.sgpcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liuyu7177.sgpcweb.config.client")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SgPcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgPcWebApplication.class, args);
    }

}
