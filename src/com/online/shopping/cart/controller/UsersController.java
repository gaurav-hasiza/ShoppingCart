package com.online.shopping.cart.controller;

import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.dtos.response.UserCreateResponseDTO;
import com.online.shopping.cart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0/users")
public class UsersController {
    @Autowired
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserCreateResponseDTO> createUser(@RequestBody UserCreateRequestDTO createUserRequest) {
        userService.createUser(createUserRequest);
        user.setRole(Role.USER); // Set the default role to USER for new users
        User createdUser = userService.createUser(createUserRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateOrUpdateUserRequest createOrUpdateUserRequest) {
        try {
            CreateUserResponse userResponse = userService.create(createOrUpdateUserRequest);
            return new ResponseEntity(userResponse, HttpStatus.CREATED);
        } catch (CartServiceException cse) {
            return new ResponseEntity(cse.getMessage(), cse.getHttpStatus());
        }
    }
}
