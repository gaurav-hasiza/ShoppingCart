package com.online.shopping.cart.entity;

import com.online.shopping.cart.enums.SessionStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Session extends BaseEntity{
    private String sessionId;
    private LocalDateTime expiryAt;
    private SessionStatus status;
}
