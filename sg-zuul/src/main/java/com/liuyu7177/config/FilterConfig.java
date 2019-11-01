package com.liuyu7177.config;

import com.liuyu7177.filter.ErrorFilter;
import com.liuyu7177.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuyu7177 On 2019/11/1
 *
 * @author liuyu
 */
@Configuration
public class FilterConfig {
    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
