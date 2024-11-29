package com.hieptran.orderservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
@RequiredArgsConstructor
public class CartService extends AbstractCircuitBreakFallbackHandler{
    private final HttpClient httpClient;

    @Retry(name= "restApi")
    @CircuitBreaker(name = "restCircuitBreaker", fallbackMethod = "handleBodilessFallback")
    public void deleteCartItem() {


    }
}
