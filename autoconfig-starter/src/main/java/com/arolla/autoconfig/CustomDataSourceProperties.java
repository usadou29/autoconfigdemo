package com.arolla.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.arolla.datasource")
public class CustomDataSourceProperties {
    private boolean enabled;
    private String driverClassName = "org.h2.Driver";
    private String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    private String username = "sa-autoconfig";
    private String password;

    public void validate() {
        if (this.url == null || this.url.isEmpty()) {
            throw new IllegalArgumentException("Property 'url' must not be empty");
        }
        if (this.driverClassName == null || this.driverClassName.isEmpty()) {
            throw new IllegalArgumentException("Property 'driverClassName' must not be empty");
        }
        if (this.username == null || this.username.isEmpty()) {
            throw new IllegalArgumentException("Property 'username' must not be empty");
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}