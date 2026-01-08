package com.traveleasy.backend.auth.service;

import com.traveleasy.backend.auth.model.LoginRequest;
import com.traveleasy.backend.auth.model.LoginResponse;
import com.traveleasy.backend.common.exception.DomainException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StubAuthService implements AuthService {

    private final String adminUsername;
    private final String adminPassword;

    public StubAuthService(@Value("${app.admin.username:admin}") String adminUsername,
                           @Value("${app.admin.password:admin123}") String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    @Override
    public LoginResponse authenticate(LoginRequest request) {
        if (!adminUsername.equals(request.username()) || !adminPassword.equals(request.password())) {
            throw new DomainException("Невірні облікові дані");
        }
        var token = UUID.randomUUID().toString();
        return new LoginResponse(token, "ADMIN");
    }
}
