package com.arolla.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.arolla.logservice")
public class LogServiceProperties {
    private String format;
}
