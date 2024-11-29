package com.hieptran.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService extends AbstractCircuitBreakFallbackHandler{
}
