package com.mec.dnaVerifier.security.role;

import com.mec.dnaVerifier.exception.RoleNotFoundException;
import com.mec.dnaVerifier.security.abstraction.IRoleRepository;
import com.mec.dnaVerifier.security.abstraction.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;
    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(String name) {
        Role role = new Role();
        role.setDescription(name);
        role.setName(name);
        role.setTimestamp(new Timestamp(System.currentTimeMillis()));
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) throws RoleNotFoundException {
        Optional<Role> role = roleRepository.findByName(name);
        if(role.isEmpty()) throw new RoleNotFoundException("Role not found");
        return role.get();
    }
}
