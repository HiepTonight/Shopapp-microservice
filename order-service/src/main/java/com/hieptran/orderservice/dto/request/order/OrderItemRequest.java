package com.hieptran.orderservice.dto.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {

    private String productId;

    private String productName;

    private int quantity;

    private BigDecimal productPrice;

    private String productDescription;

    private BigDecimal discountAmount;

    private BigDecimal taxAmount;

    private BigDecimal taxPercent;
}
