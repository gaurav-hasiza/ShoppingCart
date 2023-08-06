package com.online.shopping.cart.entity;

import java.time.Instant;

public class SessionData {
    private User user;
    private Instant expirationTime;

    public SessionData(User user, Instant expirationTime) {
        this.user = user;
        this.expirationTime = expirationTime;
    }

    public User getUser() {
        return user;
    }

    public Instant getExpirationTime() {
        return expirationTime;
    }
}