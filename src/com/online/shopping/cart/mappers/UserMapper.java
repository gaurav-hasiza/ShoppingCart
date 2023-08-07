package com.online.shopping.cart.mappers;

import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.entity.User;

public class UserMapper {
    public static User mapToUser(UserCreateRequestDTO userCreateRequestDTO){
        return User.builder().name(userCreateRequestDTO.getName())
                .password(userCreateRequestDTO.getPassword())
                .userRole(userCreateRequestDTO.getUserRole()).build();
    }
}
