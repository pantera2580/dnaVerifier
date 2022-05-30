package com.mec.dnaVerifier.security.user;

import com.mec.dnaVerifier.exception.RoleNotFoundException;
import com.mec.dnaVerifier.security.abstraction.IRoleService;
import com.mec.dnaVerifier.security.abstraction.IUserRepository;
import com.mec.dnaVerifier.security.abstraction.IUserService;
import com.mec.dnaVerifier.security.jwt.JwtProvider;

import com.mec.dnaVerifier.security.role.Role;
import com.mec.dnaVerifier.util.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired @Lazy
    private AuthenticationManager authenticationManager;
    @Autowired @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findUserByUsername(username);
        return UserAuth.buildUser(user);

    }
    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("Username not found");
        return user.get();
    }

    @Override
    public UserDetailsResponse save(UserDetailsRequest userDetailsRequest) throws RoleNotFoundException {
        User user = AuthMapper.userDtoToEntity(userDetailsRequest);
        Role role = roleService.findByName("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        userRepository.save(user);
        return AuthMapper.entityToUserResponse(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        return new LoginResponse(jwt);
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
