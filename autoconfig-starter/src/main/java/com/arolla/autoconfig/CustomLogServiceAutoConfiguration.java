package com.arolla.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LogServiceProperties.class)
@ConditionalOnProperty(name = "com.arolla.logservice.enabled", havingValue = "true", matchIfMissing = true)
public class CustomLogServiceAutoConfiguration {

    @Bean
    public LogService logService(LogServiceProperties properties) {
        return new LogService(properties.getFormat());
    }
}