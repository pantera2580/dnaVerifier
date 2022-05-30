package com.mec.dnaVerifier.security.abstraction;

import com.mec.dnaVerifier.exception.RoleNotFoundException;
import com.mec.dnaVerifier.security.role.Role;

import java.util.Optional;

public interface IRoleService {
    void save(String name);
    Role findByName(String name) throws RoleNotFoundException;
}
