package com.hieptran.orderservice.dto.response.order;

import com.hieptran.orderservice.dto.request.order.OrderItemRequest;
import com.hieptran.orderservice.model.Order;
import com.hieptran.orderservice.model.enumeration.DeliveryMethod;
import com.hieptran.orderservice.model.enumeration.DeliveryStatus;
import com.hieptran.orderservice.model.enumeration.OrderStatus;
import com.hieptran.orderservice.model.enumeration.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private String orderId;

    private String email;

    private OrderAddressResponse shippingAddressResponse;

    private OrderAddressResponse billingAddressResponse;

    private String note;

    private float tax;

    private float discount;

    private int numberItem;

    private BigDecimal totalPrice;

    private BigDecimal deliveryFee;

    private String couponCode;

    private OrderStatus orderStatus;

    private DeliveryMethod deliveryMethod;

    private DeliveryStatus deliveryStatus;

    private PaymentStatus paymentStatus;

    private Set<OrderItemResponse> orderItems;

    public static OrderResponse fromOrder(Order order) {
        Set<OrderItemResponse> orderItemResponses = order.getOrderItems().stream().map(
                OrderItemResponse::fromOrder
        ).collect(Collectors.toSet());

        return OrderResponse.builder()
                .orderId(order.getId())
                .email(order.getEmail())
                .shippingAddressResponse(OrderAddressResponse.fromOrder(order.getShippingAddressId()))
                .billingAddressResponse(OrderAddressResponse.fromOrder(order.getBillingAddressId()))
                .note(order.getNote())
                .tax(order.getTax())
                .discount(order.getDiscount())
                .numberItem(order.getNumberItem())
                .totalPrice(order.getTotalPrice())
                .deliveryFee(order.getDeliveryFee())
                .couponCode(order.getCouponCode())
                .orderStatus(order.getOrderStatus())
                .deliveryMethod(order.getDeliveryMethod())
                .deliveryStatus(order.getDeliveryStatus())
                .paymentStatus(order.getPaymentStatus())
                .orderItems(orderItemResponses)
                .build();
    }
}
