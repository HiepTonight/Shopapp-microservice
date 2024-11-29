package com.hieptran.orderservice.dto.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAddressRequest {

    private String contactName;

    private String contactPhone;

//    private String contactEmail;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String zipCode;

    private Long districtId;

    private String districtName;

    private Long provinceId;

    private String provinceName;

    private Long countryId;

    private String countryName;
}
