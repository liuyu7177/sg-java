package com.liuyu7177.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by libiyan on 2019/10/26.
 * @author liuyu
 */
@Data
public class ApolloDBConfig {
    @Value("${apolloName:100}")
    private  String apolloName;
}
