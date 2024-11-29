package com.hieptran.orderservice.service;

import com.hieptran.common.model.builder.ResponseBuilder;
import com.hieptran.common.model.dto.ApiResponse;
import com.hieptran.common.model.enums.StatusCodeEnum;
import com.hieptran.orderservice.dto.request.order.OrderAddressRequest;
import com.hieptran.orderservice.dto.request.order.OrderRequest;
import com.hieptran.orderservice.dto.response.order.OrderResponse;
import com.hieptran.orderservice.model.Order;
import com.hieptran.orderservice.model.OrderAddress;
import com.hieptran.orderservice.model.OrderItem;
import com.hieptran.orderservice.model.enumeration.DeliveryStatus;
import com.hieptran.orderservice.repository.OrderItemRepository;
import com.hieptran.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final CartService cartService;

    public ResponseEntity<ApiResponse<OrderResponse>>  createOrder(OrderRequest orderRequest) {

        OrderAddressRequest billingAddressPost = orderRequest.getBillingAddressRequest();
        OrderAddress billingOrderAddress = OrderAddress.builder()
                .phone(billingAddressPost.getContactPhone())
                .contactName(billingAddressPost.getContactName())
                .addressLine1(billingAddressPost.getAddressLine1())
                .addressLine2(billingAddressPost.getAddressLine2())
                .city(billingAddressPost.getCity())
                .zipCode(billingAddressPost.getZipCode())
                .districtId(billingAddressPost.getDistrictId())
                .districtName(billingAddressPost.getDistrictName())
                .stateOrProvinceId(billingAddressPost.getProvinceId())
                .stateOrProvinceName(billingAddressPost.getProvinceName())
                .countryId(billingAddressPost.getCountryId())
                .countryName(billingAddressPost.getCountryName())
                .build();

        OrderAddressRequest shippingAddressPost = orderRequest.getShippingAddressRequest();
        OrderAddress shippingOrderAddress = OrderAddress.builder()
                .phone(shippingAddressPost.getContactPhone())
                .contactName(shippingAddressPost.getContactName())
                .addressLine1(shippingAddressPost.getAddressLine1())
                .addressLine2(shippingAddressPost.getAddressLine2())
                .city(shippingAddressPost.getCity())
                .zipCode(shippingAddressPost.getZipCode())
                .districtId(shippingAddressPost.getDistrictId())
                .districtName(shippingAddressPost.getDistrictName())
                .stateOrProvinceId(shippingAddressPost.getProvinceId())
                .stateOrProvinceName(shippingAddressPost.getProvinceName())
                .countryId(shippingAddressPost.getCountryId())
                .countryName(shippingAddressPost.getCountryName())
                .build();

        Order order = Order.builder()
                .email(orderRequest.getEmail())
                .note(orderRequest.getNote())
                .tax(orderRequest.getTax())
                .discount(orderRequest.getDiscount())
                .numberItem(orderRequest.getNumberItem())
                .totalPrice(orderRequest.getTotalPrice())
                .couponCode(orderRequest.getCouponCode())
                .orderStatus(orderRequest.getOrderStatus())
                .deliveryFee(orderRequest.getDeliveryFee())
                .deliveryMethod(orderRequest.getDeliveryMethod())
                .deliveryStatus(DeliveryStatus.PREPARING)
                .paymentStatus(orderRequest.getPaymentStatus())
                .shippingAddressId(shippingOrderAddress)
                .billingAddressId(billingOrderAddress)
                .checkoutId(orderRequest.getCheckoutId())
                .build();

        try {
            orderRepository.save(order);
        } catch (Exception e) {
            return ResponseBuilder.badRequestResponse("Failed to save order", StatusCodeEnum.ORDER0200);
        }


        Set<OrderItem> orderItems = orderRequest.getOrderItems().stream()
                .map(item -> OrderItem.builder()
                        .productId(item.getProductId())
                        .productName(item.getProductName())
                        .quantity(item.getQuantity())
                        .productPrice(item.getProductPrice())
                        .productDescription(item.getProductDescription())
                        .orderId(order)
                        .build())
                .collect(Collectors.toSet());

        orderItemRepository.saveAll(orderItems);

        order.setOrderItems(orderItems);
        OrderResponse orderResponse = OrderResponse.fromOrder(order);

//        productService;
//        cartService;
//        acceptOrder;
        return ResponseBuilder.successResponse("Order created", orderResponse, StatusCodeEnum.ORDER1200);
    }

    public OrderResponse getOrderWithItemById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException());
        return OrderResponse.fromOrder(order);
    }
}
