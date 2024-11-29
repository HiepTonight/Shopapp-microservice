package com.hieptran.orderservice.dto.response.order;

import com.hieptran.orderservice.model.OrderAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAddressResponse {
    private String id;

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

    public static OrderAddressResponse fromOrder(OrderAddress orderAddress) {
        return OrderAddressResponse.builder()
                .id(orderAddress.getId())
                .contactPhone(orderAddress.getPhone())
                .contactName(orderAddress.getContactName())
                .addressLine1(orderAddress.getAddressLine1())
                .addressLine2(orderAddress.getAddressLine2())
                .city(orderAddress.getCity())
                .zipCode(orderAddress.getZipCode())
                .districtId(orderAddress.getDistrictId())
                .districtName(orderAddress.getDistrictName())
                .provinceId(orderAddress.getStateOrProvinceId())
                .provinceName(orderAddress.getStateOrProvinceName())
                .countryId(orderAddress.getCountryId())
                .countryName(orderAddress.getCountryName())
                .build();
    }
}
