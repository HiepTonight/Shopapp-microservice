package com.hieptran.orderservice.exception;

import com.hieptran.common.exception.BadRequestException;
import com.hieptran.common.exception.NotFoundException;
import com.hieptran.common.exception.SignInRequiredException;
import com.hieptran.common.exception.UserDoesNotHavePermission;
import com.hieptran.common.model.dto.ApiResponse;
import com.hieptran.common.model.enums.StatusCodeEnum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public <T> ResponseEntity<ApiResponse<T>> handleNotFoundException(NotFoundException e) {
        log.error("Exception occurred: ", e);
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0404.toString())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(BadRequestException.class)
    public <T> ResponseEntity<ApiResponse<T>> handleBadRequestException(BadRequestException e) {
        log.error("Exception occurred: ", e);
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0400.toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public <T> ResponseEntity<ApiResponse<T>> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException: ", e);
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0503.toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<ApiResponse<List<String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .toList();

        final ApiResponse<List<String>> dto = ApiResponse.<List<String>>builder()
                .success(false)
                .data(errors)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0400.toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public static ResponseEntity<ApiResponse<List<String>>> handleConstraintViolationException(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()
                    + " " + violation.getPropertyPath() + ": " + violation.getMessage());
        }

        final ApiResponse<List<String>> dto = ApiResponse.<List<String>>builder()
                .success(false)
                .data(errors)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0400.toString())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(SignInRequiredException.class)
    public <T> ResponseEntity<ApiResponse<T>> handleSignInRequiredException(SignInRequiredException e) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0503.toString())
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
    }

    @ExceptionHandler(UserDoesNotHavePermission.class)
    public <T> ResponseEntity<ApiResponse<T>> handleUserDoesNotHavePermission(UserDoesNotHavePermission e) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0503.toString())
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public <T> ResponseEntity<ApiResponse<T>> handleAccessDeniedException(AccessDeniedException e) {
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION0503.toString())
                .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public <T> ResponseEntity<ApiResponse<T>> handleException(Exception e) {
        log.error("Exception occurred: ", e);
        final ApiResponse<T> dto = ApiResponse.<T>builder()
                .success(false)
                .message(e.getMessage())
                .statusCode(StatusCodeEnum.EXCEPTION.toString())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }
}
