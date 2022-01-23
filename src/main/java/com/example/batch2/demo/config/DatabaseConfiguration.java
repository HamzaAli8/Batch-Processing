package com.example.batch2.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${batchDatasource.driver}") private String batchDatasourceDriver;
    @Value("${batchDatasource.url}") private String batchDatasourceUrl;
    @Value("${batchDatasource.username}") private String batchDatasourceUsername;
    @Value("${batchDatasource.password}") private String batchDatasourcePassword;



    @Bean
    @BatchDataSource
    // @BatchDataSource annotation is used to specify that this bean will be used as the data source for the ItemReader during Batch Processing
    public DataSource batchDatasource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(batchDatasourceDriver);
        config.setJdbcUrl(batchDatasourceUrl);
        config.setUsername(batchDatasourceUsername);
        config.setPassword(batchDatasourcePassword);
        return new HikariDataSource(config);
    }
}
