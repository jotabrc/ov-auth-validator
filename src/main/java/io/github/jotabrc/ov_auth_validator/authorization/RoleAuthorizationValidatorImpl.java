package io.github.jotabrc.ov_auth_validator.authorization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleAuthorizationValidatorImpl implements RoleAuthorizationValidator {

    @Value("${exception.message.role}")
    private String message;

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
