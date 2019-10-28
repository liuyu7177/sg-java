package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SgDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgDataApplication.class, args);
    }

}
