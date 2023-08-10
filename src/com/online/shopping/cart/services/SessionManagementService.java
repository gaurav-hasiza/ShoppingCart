package com.online.shopping.cart.services;

import com.online.shopping.cart.entity.SessionData;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.repositories.SessionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

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
//
//    public void validate(SessionData session) {
//        if (SessionStatus.LOGOUT.equals(session.getStatus())) {
//            throw new CartServiceException(ErrorMessages.INVALID_SESSION_ID.getErrorMessage(), HttpStatus.UNAUTHORIZED);
//        }
//        if (session.getExpiryAt().isBefore(LocalDateTime.now())) {
//            throw new CartServiceException(ErrorMessages.SESSION_EXPIRED.getErrorMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }

    public void logout(String sessionId) {
        sessionRepo.removeSession(sessionId);
    }

    public User getUserBySessionId(String sessionId) {
        SessionData sessionData =sessionRepo.getSessionData(sessionId);
        if (sessionData != null && !isSessionExpired(sessionData)) {
            return sessionData.getUser();
        }
        throw new RuntimeException("Invalid Session");
//        return null;
    }

    private boolean isSessionExpired(SessionData sessionData) {
        return Instant.now().isAfter(sessionData.getExpirationTime());
    }

    private String generateSessionId() {
        // You can implement a more sophisticated session ID generation mechanism here
        return UUID.randomUUID().toString();
    }
}
