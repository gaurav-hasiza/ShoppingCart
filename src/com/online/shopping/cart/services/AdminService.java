package com.online.shopping.cart.services;

import com.online.shopping.cart.repositories.UserRepository;

public class AdminService {
    UserRepository userRepository;

    public void suspendUser(String userID) {
        userRepository.suspend(userID);
    }

}
