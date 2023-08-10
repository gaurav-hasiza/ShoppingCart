package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.AccountStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository implements IUserRepo {
    private static final HashMap<String,User> idUsersMapping = new HashMap<>();

    @Override
    public User findById(String userId) {
        if (idUsersMapping.containsKey(userId)) {
            return idUsersMapping.get(userId);
        }
        throw new IllegalArgumentException("User Not Found");
    }

    // Method to add a user to the repository
    @Override
    public User addUser(User user) {
        user.setId(generateUserId());
        idUsersMapping.put(user.getId(), user);
        return user;
    }
    private String generateUserId() {
        return UUID.randomUUID().toString();
    }

    public void suspend(String userId){
        if (idUsersMapping.containsKey(userId)) {
            User user = idUsersMapping.get(userId);

            user.setAccountStatus(AccountStatus.SUSPENDED);
        }
        throw new IllegalArgumentException("User Not found");
    }

    @Override
    public User update(User entity) {
        return null;
    }

    // Method to find a user by username
    public User findUserByUsername(String username) {
        for (User user : idUsersMapping.values()) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Method to get all users (for demonstration purposes)
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(idUsersMapping.values());
    }
}

