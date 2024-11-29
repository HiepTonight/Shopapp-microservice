package com.hieptran.orderservice.repository;

import com.hieptran.orderservice.model.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, String> {
}
