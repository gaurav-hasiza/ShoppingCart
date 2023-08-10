package com.online.shopping.cart.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginResponseDTO {
    private String sessionId;
//    LocalDateTime expiryTime;
}
