package com.flame_guard.api.dtos.auth;

import com.flame_guard.api.domains.user.UserRole;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
