package com.hieptran.orderservice.repository;

import com.hieptran.orderservice.model.CheckoutItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutItemRepository extends JpaRepository<CheckoutItem, String> {
}
