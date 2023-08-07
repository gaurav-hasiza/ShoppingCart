package com.online.shopping.cart.mappers;

import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.dtos.response.UserCreateResponseDTO;
import com.online.shopping.cart.entity.User;

public class UserMapper {
    public static User mapToUser(UserCreateRequestDTO userCreateRequestDTO){
        return User.builder().name(userCreateRequestDTO.getName())
                .password(userCreateRequestDTO.getPassword())
                .userRole(userCreateRequestDTO.getUserRole()).build();
    }

    public static UserCreateResponseDTO mapTOUserCreateResponse(User user){
        return UserCreateResponseDTO.builder().UserID(user.getId()).name(user.getName())
                .userRole(user.getUserRole()).build();
    }
}
