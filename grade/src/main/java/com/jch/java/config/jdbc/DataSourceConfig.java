package com.jch.java.config.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/12/18.
 */
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    @Bean(name="dataSource", destroyMethod = "close", initMethod="init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
}
