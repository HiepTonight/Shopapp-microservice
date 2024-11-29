package com.hieptran.orderservice.repository;

import com.hieptran.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

}
