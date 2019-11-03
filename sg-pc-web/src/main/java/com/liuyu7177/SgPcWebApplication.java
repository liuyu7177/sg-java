package com.liuyu7177;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuyu
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liuyu7177.config.client")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableHystrix
@ComponentScan(basePackages = {"com.liuyu7177.*"})
public class SgPcWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgPcWebApplication.class, args);
    }
}
