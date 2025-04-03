package io.github.jotabrc.ov_auth_validator.authorization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsernameAuthorizationValidatorImpl implements UsernameAuthorizationValidator {

    @Value("${exception.message.username}")
    private String message;

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
