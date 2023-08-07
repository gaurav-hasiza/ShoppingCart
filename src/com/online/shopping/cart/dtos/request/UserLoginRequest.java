package com.online.shopping.cart.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequest {
    private String id;
    private String password;
}
