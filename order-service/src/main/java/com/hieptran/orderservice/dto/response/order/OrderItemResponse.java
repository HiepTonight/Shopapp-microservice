package com.hieptran.orderservice.dto.response.order;

import com.hieptran.orderservice.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponse {
    private String id;

    private String orderId;

    private String productId;

    private String productName;

    private int quantity;

    private BigDecimal productPrice;

    private String productDescription;

    private BigDecimal discountAmount;

    private BigDecimal taxAmount;

    private BigDecimal taxPercent;

    public static OrderItemResponse fromOrder(OrderItem orderItem) {
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .productId(orderItem.getProductId())
                .productName(orderItem.getProductName())
                .quantity(orderItem.getQuantity())
                .productPrice(orderItem.getProductPrice())
                .productDescription(orderItem.getProductDescription())
                .discountAmount(orderItem.getDiscountAmount())
                .taxPercent(orderItem.getTaxPercent())
                .taxAmount(orderItem.getTaxAmount())
                .orderId(orderItem.getOrderId().getId())
                .build();
    }
}
