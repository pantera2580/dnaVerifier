package com.mec.dnaVerifier.security.abstraction;

import com.mec.dnaVerifier.exception.RoleNotFoundException;
import com.mec.dnaVerifier.security.user.*;

public interface IUserService {
    User findUserByUsername(String username);
    UserDetailsResponse save(UserDetailsRequest userDetailsRequest) throws RoleNotFoundException;
    LoginResponse login(LoginRequest loginRequest);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
