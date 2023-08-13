package com.online.shopping.cart.controllers;

import com.online.shopping.cart.controller.UsersController;
import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.dtos.request.UserLoginRequest;
import com.online.shopping.cart.dtos.response.UserCreateResponseDTO;
import com.online.shopping.cart.dtos.response.UserLoginResponseDTO;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.AccountStatus;
import com.online.shopping.cart.enums.UserRole;
import com.online.shopping.cart.services.SessionManagementService;
import com.online.shopping.cart.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UsersControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private SessionManagementService sessionManagementService;

    @InjectMocks
    private UsersController usersController;

    @BeforeEach
    void setUp() {
        // Initialize the mocks
        userService = mock(UserService.class);
        sessionManagementService = mock(SessionManagementService.class);
        usersController = new UsersController(userService, sessionManagementService);
    }

    @Test
    void testCreateUser() {
        UserCreateRequestDTO createUserRequest = new UserCreateRequestDTO("username", "password", UserRole.ADMIN);
        User createdUser = new User("username", UserRole.ADMIN, AccountStatus.ACTIVE, "password", true);
        when(userService.createUser(createUserRequest)).thenReturn(createdUser);

        ResponseEntity responseEntity = usersController.createUser(createUserRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof UserCreateResponseDTO);
        verify(userService, times(1)).createUser(createUserRequest);
    }

    @Test
    void testLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest("username", "password");
        UserLoginResponseDTO loginResponse = new UserLoginResponseDTO("sessionId");
        when(userService.login(userLoginRequest)).thenReturn(loginResponse);

        ResponseEntity responseEntity = usersController.login(userLoginRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof UserLoginResponseDTO);
        verify(userService, times(1)).login(userLoginRequest);
    }

    @Test
    void testLogout() {
        String sessionId = "testSessionId";
        doNothing().when(sessionManagementService).logout(sessionId);

        ResponseEntity responseEntity = usersController.logout(sessionId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Session Logged out", responseEntity.getBody());
        verify(sessionManagementService, times(1)).logout(sessionId);
    }
}
