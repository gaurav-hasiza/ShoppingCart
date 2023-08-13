package com.online.shopping.cart.controller;

import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.dtos.request.UserLoginRequest;
import com.online.shopping.cart.dtos.response.UserCreateResponseDTO;
import com.online.shopping.cart.dtos.response.UserLoginResponseDTO;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.mappers.UserMapper;
import com.online.shopping.cart.services.SessionManagementService;
import com.online.shopping.cart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v0/users")
public class UsersController {
    private final UserService userService;

    private final SessionManagementService sessionManagementService;

    @Autowired
    public UsersController(UserService userService, SessionManagementService sessionManagementService) {
        this.userService = userService;
        this.sessionManagementService = sessionManagementService;
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserCreateRequestDTO createUserRequest) {
        try {
            User createdUser = userService.createUser(createUserRequest);
            UserCreateResponseDTO response = UserMapper.mapTOUserCreateResponse(createdUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (RuntimeException runtimeException){
            return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    // Login
    /**
     * Login API to login and generate a session id
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserLoginRequest request) {
        try {
            UserLoginResponseDTO loginResponse = userService.login(request);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    // logout
    @PostMapping(value = "/logout")
    public ResponseEntity logout(@RequestHeader("sessionId") String cookieHeader) {
        try {
            // validate session
            sessionManagementService.logout(cookieHeader);
            return new ResponseEntity<>("Session Logged out", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
