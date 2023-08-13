package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.SessionData;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.repositories.SessionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class SessionManagementService {
    private static final long SESSION_TIMEOUT_MS = 30 * 60 * 1000; // 30 minutes

    private final SessionRepo sessionRepo;

    public String createSession(User user) {
        Instant expirationTime = Instant.now().plusMillis(SESSION_TIMEOUT_MS);
        String sessionId = sessionRepo.createSession(user, expirationTime);
        return sessionId;
    }


    public void logout(String sessionId) {
        sessionRepo.removeSession(sessionId);
    }

    public User getUserBySessionId(String sessionId) {
        SessionData sessionData = sessionRepo.getSessionData(sessionId);
        if (sessionData != null && !isSessionExpired(sessionData)) {
            return sessionData.getUser();
        }
        throw new RuntimeException("Invalid Session");
    }

    private boolean isSessionExpired(SessionData sessionData) {
        return Instant.now().isAfter(sessionData.getExpirationTime());
    }
}
