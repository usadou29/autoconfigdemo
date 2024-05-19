package com.arolla.autoconfig;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@AutoConfiguration(before = DataSourceAutoConfiguration.class)
@ConditionalOnClass(DataSource.class)
@EnableConfigurationProperties(CustomDataSourceProperties.class)
public class CustomDataSourceAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CustomDataSourceAutoConfiguration.class);
    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "com.arolla.datasource", name = "enabled", havingValue = "true")
    public DataSource dataSource(CustomDataSourceProperties properties) {
        properties.validate();
        logger.info("Initializing custom DataSource with properties: username={}, driverClassName={}, url={}",
                properties.getUsername(), properties.getDriverClassName(), properties.getUrl());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }
}