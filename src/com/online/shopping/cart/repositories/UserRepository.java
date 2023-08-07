package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.AccountStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class UserRepository implements IUserRepo {
    private List<User> users;
    HashMap<String,User> idUsersMapping;

    public UserRepository() {
        users = new ArrayList<>();
    }

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
        users.add(user);
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

    // Method to remove a user from the repository
//    @Override
//    public void removeUser(User user) {
//        users.remove(user);
//    }

    @Override
    public User update(User entity) {
        return null;
    }

    // Method to find a user by username
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Method to get all users (for demonstration purposes)
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}

