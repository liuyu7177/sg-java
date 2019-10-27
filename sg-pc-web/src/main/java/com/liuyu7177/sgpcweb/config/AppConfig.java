package com.liuyu7177.sgpcweb.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by libiyan on 2019/10/26.
 * @author  liuyu
 */
@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public ApolloDBConfig dbConfig() {
        return new ApolloDBConfig();
    }
}
