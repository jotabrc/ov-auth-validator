package io.github.jotabrc.ov_auth_validator.authorization;

/**
 * Spring boot component. Implements RoleAuthorizationValidator interface.
 * Validates if the provided roles (params) match the `SecurityContextHolder` Authorities.
 */
public interface RoleAuthorizationValidator {

    /**
     * Validate with any required roles match `SecurityContextHolder` Authorities.
     * @param roles Roles to be matched with `SecurityContextHolder` Authorities.
     */
    void validate(String... roles);
}
