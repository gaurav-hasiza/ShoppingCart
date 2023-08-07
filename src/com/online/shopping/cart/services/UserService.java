package com.online.shopping.cart.services;

import com.online.shopping.cart.dtos.request.UserCreateRequestDTO;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.AccountStatus;
import com.online.shopping.cart.mappers.UserMapper;
import com.online.shopping.cart.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public User createUser(UserCreateRequestDTO userCreateRequestDTO) {
         User user = UserMapper.mapToUser(userCreateRequestDTO);
         user.setAccountStatus(AccountStatus.ACTIVE);
         user.setActive(true);
         return userRepository.addUser(user);
    }

    User getUserByID(String userId){
        return userRepository.findById(userId);
    }



}
