# Authentication Validator
Intended as a shared library for authentication validation of username and roles stored in `SecurityContextHolder`.<br/>
`Authorities` for roles and `Name` for username.

### Usage
- Username: `void validate(String username);` throws `AuthorizationDeniedException` if invalid.
- Roles: `void validate(String... roles);` throws `AuthorizationDeniedException` if invalid.