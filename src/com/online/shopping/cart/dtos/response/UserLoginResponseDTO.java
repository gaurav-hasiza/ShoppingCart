package com.online.shopping.cart.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserLoginResponseDTO {
    private String sessionId;
//    LocalDateTime expiryTime;
}
