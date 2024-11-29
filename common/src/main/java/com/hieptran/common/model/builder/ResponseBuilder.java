package com.hieptran.common.model.builder;

import com.hieptran.common.model.dto.ApiResponse;
import com.hieptran.common.model.dto.MetaData;
import com.hieptran.common.model.enums.StatusCodeEnum;
import jakarta.annotation.Nonnull;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseBuilder {

    @Nonnull
    public static <T> ResponseEntity<ApiResponse<T>> successResponse(String message, StatusCodeEnum statusCode) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .statusCode(statusCode.toString())
                .build();
        return ResponseEntity.ok(dto);
    }

    public static <T> ResponseEntity<ApiResponse<T>> successResponse(String message, @Nonnull T body , StatusCodeEnum statusCode) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(body)
                .statusCode(statusCode.toString())
                .build();
        return ResponseEntity.ok(dto);
    }

    @Nonnull
    public static <T> ResponseEntity<ApiResponse<T>> successResponse(String message, @Nonnull T body , StatusCodeEnum statusCode, MetaData metaData) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(body)
                .statusCode(statusCode.toString())
                .metaData(metaData)
                .build();
        return ResponseEntity.ok(dto);
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequestResponse(String message, StatusCodeEnum statusCode) {
        final ApiResponse<T> dto = ApiResponse.<T>
                        builder()
                .success(false)
                .message(message)
                .statusCode(statusCode.toString())
                .build();
        return ResponseEntity.ok(dto);
    }

    public static <T> ResponseEntity<ApiResponse<T>> badRequestResponse(String message, @Nonnull T body, StatusCodeEnum statusCode) {
        final ApiResponse<T> dto = ApiResponse.<T>
                        builder()
                .success(false)
                .message(message)
                .data(body)
                .statusCode(statusCode.toString())
                .build();
        return ResponseEntity.ok(dto);
    }
}

