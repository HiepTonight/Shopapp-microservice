package com.hieptran.orderservice.repository;

import com.hieptran.orderservice.model.Checkout;
import com.hieptran.orderservice.model.enumeration.CheckoutState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckoutRepository extends JpaRepository<Checkout, String> {
    Optional<Checkout> findByIdAndCheckoutState(String s, CheckoutState checkoutState);
}
