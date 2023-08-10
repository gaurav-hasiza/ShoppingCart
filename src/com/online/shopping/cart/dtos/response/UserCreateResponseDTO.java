package com.online.shopping.cart.dtos.response;

import com.online.shopping.cart.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserCreateResponseDTO {
    private String UserID;
    private String name;
    private UserRole userRole;
}
