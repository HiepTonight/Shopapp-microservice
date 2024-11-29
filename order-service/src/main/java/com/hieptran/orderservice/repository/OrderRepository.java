package com.hieptran.orderservice.repository;

import com.hieptran.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

}
