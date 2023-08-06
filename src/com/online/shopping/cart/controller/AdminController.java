package com.online.shopping.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setRole(Role.USER); // Set the default role to USER for new users
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/users/{username}/suspend")
    public ResponseEntity<String> suspendUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        if (user.getRole() == Role.ADMIN) {
            return new ResponseEntity<>("Cannot suspend admin users", HttpStatus.BAD_REQUEST);
        }

        // Implement suspension logic
        // ...

        return new ResponseEntity<>("User suspended successfully", HttpStatus.OK);
    }

    // Other admin-related methods
}

