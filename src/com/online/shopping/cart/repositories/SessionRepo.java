package com.online.shopping.cart.repositories;

import java.util.HashMap;
import java.util.Map;
import com.online.shopping.cart.entity.SessionData;
import com.online.shopping.cart.entity.User;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionRepo {
    private Map<String, SessionData> activeSessions;

    public SessionRepo() {
        activeSessions = new HashMap<>();
    }

    public String createSession(User user, Instant expirationTime) {
        String sessionId = generateSessionId();
//        Instant expirationTime = Instant.now().plusMillis(SESSION_TIMEOUT_MS);
        SessionData sessionData = new SessionData(user, expirationTime);
        activeSessions.put(sessionId, sessionData);
        return sessionId;
    }

    public void removeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public SessionData getSessionData(String sessionId) {
        return activeSessions.get(sessionId);
    }

    private String generateSessionId() {
        // You can implement a more sophisticated session ID generation mechanism here
        return UUID.randomUUID().toString();
    }
}

