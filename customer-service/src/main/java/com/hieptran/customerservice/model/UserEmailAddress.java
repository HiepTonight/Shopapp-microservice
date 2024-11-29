package com.hieptran.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_email_address")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEmailAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String emailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userInfoModelId", referencedColumnName = "id")
    private UserInfoModel userInfoModelId;
}
