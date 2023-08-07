package com.online.shopping.cart.controller;

import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.UserRole;
import com.online.shopping.cart.services.AdminService;
import com.online.shopping.cart.services.SessionManagementService;
import com.online.shopping.cart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v0/admin")
public class AdminController {
    private final AdminService adminService;
    private final SessionManagementService sessionService;
    private final UserService userService;
    @Autowired
    public AdminController(AdminService adminService, UserService userService,
                           SessionManagementService sessionService) {
        this.adminService = adminService;
        this.userService = userService;
        this.sessionService = sessionService;
    }

    @PostMapping("/users/{userID}/suspend")
    public ResponseEntity<String> suspendUser(@RequestHeader("Cookie") String cookieHeader,
                                              @PathVariable String userID) {
        User currUser = sessionService.getUserBySessionId(cookieHeader);
        if (currUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        if (currUser.getUserRole() != UserRole.ADMIN) {
            return new ResponseEntity<>("Cannot suspend users", HttpStatus.BAD_REQUEST);
        }
        adminService.suspendUser(userID);
        return new ResponseEntity<>("User suspended successfully", HttpStatus.OK);
    }

    // Other admin-related methods
}

