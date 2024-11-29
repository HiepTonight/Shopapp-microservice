package com.hieptran.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_phone_number")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userInfoModelId", referencedColumnName = "id")
    private UserInfoModel userInfoModelId;
}
