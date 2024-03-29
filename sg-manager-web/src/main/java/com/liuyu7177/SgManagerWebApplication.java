package com.liuyu7177;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuyu
 */
@ComponentScan(basePackages = {"com.liuyu7177.*"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class SgManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgManagerWebApplication.class, args);
    }

}
