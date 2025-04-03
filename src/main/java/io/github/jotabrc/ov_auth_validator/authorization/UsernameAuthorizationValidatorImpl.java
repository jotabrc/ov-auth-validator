package io.github.jotabrc.ov_auth_validator.authorization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Spring boot component. Implements UsernameAuthorizationValidator interface.
 * Validates if the provided username (param) match the `SecurityContextHolder` Name.
 */
@Component
public class UsernameAuthorizationValidatorImpl implements UsernameAuthorizationValidator {

    @Value("${exception.message.username}")
    private String message;

    /**
     * Validate with any required roles match `SecurityContextHolder` Name.
     * @param username Username to be matched with `SecurityContextHolder` Name.
     */
    @Override
    public void validate(String username) {
        if (!SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equals(username)
        ) throw new AuthorizationDeniedException(message);
    }
}
