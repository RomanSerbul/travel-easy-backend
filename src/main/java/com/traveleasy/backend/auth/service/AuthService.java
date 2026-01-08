package com.traveleasy.backend.auth.service;

import com.traveleasy.backend.auth.model.LoginRequest;
import com.traveleasy.backend.auth.model.LoginResponse;

public interface AuthService {
    LoginResponse authenticate(LoginRequest request);
}
