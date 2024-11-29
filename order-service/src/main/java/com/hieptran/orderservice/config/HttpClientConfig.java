package com.hieptran.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfig {
    Duration duration = Duration.ofSeconds(5000);
    @Bean
    public HttpClient httpClient() {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(duration)
                .build();
        return httpClient;
    }
}
