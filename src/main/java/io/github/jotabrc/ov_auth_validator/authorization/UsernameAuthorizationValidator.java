package io.github.jotabrc.ov_auth_validator.authorization;

/**
 * Spring boot component. Implements UsernameAuthorizationValidator interface.
 * Validates if the provided username (param) match the `SecurityContextHolder` Name.
 */
public interface UsernameAuthorizationValidator {

    /**
     * Validate with any required roles match `SecurityContextHolder` Name.
     * @param username Username to be matched with `SecurityContextHolder` Name.
     */
    void validate(String username);
}
