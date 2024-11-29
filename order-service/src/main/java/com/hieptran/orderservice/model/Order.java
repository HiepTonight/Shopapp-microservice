package com.hieptran.orderservice.model;

import com.hieptran.orderservice.model.enumeration.DeliveryMethod;
import com.hieptran.orderservice.model.enumeration.DeliveryStatus;
import com.hieptran.orderservice.model.enumeration.OrderStatus;
import com.hieptran.orderservice.model.enumeration.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private OrderAddress shippingAddressId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private OrderAddress billingAddressId;

    private String note;

    private float tax;

    private float discount;

    private int numberItem;

    private String couponCode;

    private BigDecimal totalPrice;

    private BigDecimal deliveryFee;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private Long paymentId;

    private String checkoutId;

    private String rejectReason;
}
