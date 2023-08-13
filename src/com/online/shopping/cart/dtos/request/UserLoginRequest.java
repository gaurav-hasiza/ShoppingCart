package com.online.shopping.cart.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginRequest {
    private String id;
    private String password;
}
