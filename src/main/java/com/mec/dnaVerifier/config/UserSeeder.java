/*package com.mec.dnaVerifier.config;

import com.mec.dnaVerifier.security.abstraction.IRoleRepository;
import com.mec.dnaVerifier.security.abstraction.IUserRepository;
import com.mec.dnaVerifier.security.role.Role;
import com.mec.dnaVerifier.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final String PHOTO = "default.jpg";
    @Override
    public void run(String... args) throws Exception {
        loadRole();
        loadUser();
    }
    //create roles if they don't exist
    private void loadRole() {
        if (roleRepository.count() == 0) {
            loadRoleSeed();
        }
    }
    private void loadRoleSeed() {
        roleRepository.save(buildRole("ROLE_ADMIN",
                "Has all the privileges from both roles"));
        roleRepository.save(buildRole("ROLE_USER",
                "Privileges limited to only modifying and viewing your data"));
    }

    private Role buildRole(String name, String description) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return role;
    }

    //create users if they don't exist
    private void loadUser() {
        if (userRepository.count() == 0) {
            loadUserSeed();
        }
    }

    private void loadUserSeed() {
        //add Admin Users
        Role roleEntityAdmin = roleRepository.findByName("ROLE_ADMIN");
        userRepository.save(buildUser("Delfin", "delfin", "delfin@mail.com", "delfin", roleEntityAdmin));
        userRepository.save(buildUser("Tiburon", "tiburon", "tiburon@mail.com", "tiburon", roleEntityAdmin));

        //add Users Example
        Role roleEntityUser = roleRepository.findByName("ROLE_USER");
        userRepository.save(buildUser("Cacatua", "cacatua", "cacatua@mail.com", "cacatua", roleEntityUser));
        userRepository.save(buildUser("Tucan", "tucan", "tucan@mail.com", "tucan", roleEntityUser));

    }

    private User buildUser(String name, String username, String email, String password, Role role) {

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return user;
    }

}*/