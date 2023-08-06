package com.online.shopping.cart.repositories;

import com.online.shopping.cart.entity.User;

import java.util.List;

public interface IUserRepo {
    User findById(String userId);
    void addUser(User user);
    void removeUser(User user);
    public User update(User entity);
    public List<User> getAllUsers();
    User findUserByUsername(String username);

}
