package com.online.shopping.cart.dtos.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLogoutRequestDTO {
    private String sessionId;
}
