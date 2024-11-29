package com.hieptran.customerservice.model;

import com.hieptran.customerservice.model.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`user_info`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoModel extends AbstractBaseEntity{
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    private GenderEnum gender;

    private String primaryPhoneNumber;

    @OneToMany(mappedBy = "userInfoModelId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserPhoneNumber> phoneNumbers;

    private String primaryEmailAddress;

    @OneToMany(mappedBy = "userInfoModelId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserEmailAddress> emailAddresses;

    private String countryName;

    private String provinceName;

    private String cityName;

    private ZonedDateTime dateOfBirth;

    private String avatar;

    private String banner;

    private String description;

    private String userId;
}
