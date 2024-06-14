package io.github.devruibin.users;

public record UserModel(Long id, String name, String email, String password, String role, boolean isActive) {
}
