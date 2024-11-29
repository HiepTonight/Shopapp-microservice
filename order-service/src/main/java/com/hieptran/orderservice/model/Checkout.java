package com.hieptran.orderservice.model;

import com.hieptran.orderservice.model.enumeration.CheckoutState;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "checkout")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Checkout extends AbstractBaseEntity {
    @Id
    private String id;

    private String email;

    private String note;

    private String couponCode;

    @Enumerated(EnumType.STRING)
    private CheckoutState checkoutState;

    @OneToMany(mappedBy = "checkoutId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CheckoutItem> checkoutItem;
}
