package com.online.shopping.cart.services;

import com.online.shopping.cart.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{
    UserRepository userRepository;

    public void suspendUser(String userID) {
        userRepository.suspend(userID);
    }

}
