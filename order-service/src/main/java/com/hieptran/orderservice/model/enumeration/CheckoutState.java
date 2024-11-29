package com.hieptran.orderservice.model.enumeration;

public enum CheckoutState {
    COMPLETED("Completed"), PENDING("Pending"), LOCK("LOCK");

    private String name;

    CheckoutState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
