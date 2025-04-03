package io.github.jotabrc.ov_auth_validator.authorization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Spring boot component. Implements RoleAuthorizationValidator interface.
 * Validates if the provided roles (params) match the `SecurityContextHolder` Authorities.
 */
@Component
public class RoleAuthorizationValidatorImpl implements RoleAuthorizationValidator {

    @Value("${exception.message.role}")
    private String message;

    /**
     * Validate with any required roles match `SecurityContextHolder` Authorities.
     * @param roles Roles to be matched with `SecurityContextHolder` Authorities.
     */
    @Override
    public void validate(String... roles) {
        if (
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getAuthorities()
                        .stream()
                        .anyMatch(grantedAuthority -> Arrays.stream(roles)
                                .anyMatch(role -> role.equals(grantedAuthority.getAuthority()))
                        )
        ) throw new AuthorizationDeniedException(message);
    }
}

