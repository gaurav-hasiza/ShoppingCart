package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.User;

public interface ISessionManagementService {
    public String createSession(User user);
    public void logout(String sessionId);
    public User getUserBySessionId(String sessionId);
}
