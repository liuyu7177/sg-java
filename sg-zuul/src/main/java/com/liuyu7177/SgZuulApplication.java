package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuyu
 */
@EnableZuulProxy
@SpringBootApplication
@ComponentScan(basePackages = {"com.liuyu7177.*"})
public class SgZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgZuulApplication.class, args);
    }

}
