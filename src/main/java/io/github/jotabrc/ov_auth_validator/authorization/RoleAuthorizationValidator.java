package io.github.jotabrc.ov_auth_validator.authorization;

public interface RoleAuthorizationValidator {

    void validate(String... roles);
}
