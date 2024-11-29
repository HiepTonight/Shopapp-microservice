package com.hieptran.orderservice.model;

import com.hieptran.orderservice.listener.CustomAuditingEntityListener;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class)
public class AbstractBaseEntity {
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;
}
