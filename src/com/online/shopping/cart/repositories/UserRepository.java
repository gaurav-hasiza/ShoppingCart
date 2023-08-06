package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepo {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    @Override
    public User findById(String userId) {
        return null;
    }

    // Method to add a user to the repository
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    // Method to remove a user from the repository
    @Override
    public void removeUser(User user) {
        users.remove(user);
    }

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

