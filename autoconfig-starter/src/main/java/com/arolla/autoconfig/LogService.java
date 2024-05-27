package com.arolla.autoconfig;

public record LogService(String format) {
    public LogService(String format) {
        this.format = format;
    }

    public void log(String message) {
        System.out.printf((format) + "%n", message);
    }
}