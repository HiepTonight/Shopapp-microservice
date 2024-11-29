package com.hieptran.orderservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopapp.services")
public record ServiceUrlConfig(
        String cart, String customer, String product, String tax) {
}
