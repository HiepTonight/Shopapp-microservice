package com.hieptran.orderservice.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractCircuitBreakFallbackHandler {

    protected void handleBodilessFallback(Throwable throwable) throws Throwable {
        handleError(throwable);
    }

    protected Object handleFallback(Throwable throwable) throws Throwable {
        handleError(throwable);
        return null;
    }

    private void handleError(Throwable throwable) throws Throwable {
        log.error(throwable.getMessage(), throwable);
        throw throwable;
    }
}
