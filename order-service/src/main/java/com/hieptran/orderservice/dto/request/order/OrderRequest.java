package com.hieptran.orderservice.dto.request.order;

import com.hieptran.orderservice.model.enumeration.DeliveryMethod;
import com.hieptran.orderservice.model.enumeration.DeliveryStatus;
import com.hieptran.orderservice.model.enumeration.OrderStatus;
import com.hieptran.orderservice.model.enumeration.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String checkoutId;

    private String email;

    private OrderAddressRequest shippingAddressRequest;

    private OrderAddressRequest billingAddressRequest;

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

    private List<OrderItemRequest> orderItems;
}
