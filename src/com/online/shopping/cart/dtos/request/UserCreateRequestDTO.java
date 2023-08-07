package com.online.shopping.cart.dtos.request;

import com.online.shopping.cart.enums.UserRole;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserCreateRequestDTO {
//    @NonNull private String userId;
    @NonNull private String name;
    @NonNull private String password;
    @NonNull private UserRole userRole;

    public UserCreateRequestDTO(@NonNull String name, @NonNull String password,
                                @NonNull UserRole userRole) {
        this.name = name;
        this.password =password;
        this.userRole = userRole;
    }
}
