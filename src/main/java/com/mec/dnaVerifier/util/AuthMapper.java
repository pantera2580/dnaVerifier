package com.mec.dnaVerifier.util;

import com.mec.dnaVerifier.security.user.*;

import java.util.Date;

public class AuthMapper {
    public static User userDtoToEntity(UserDetailsRequest userDetailsRequest){
        User user = new User();
        user.setName(userDetailsRequest.getName());
        user.setEmail(userDetailsRequest.getEmail());
        user.setPassword(userDetailsRequest.getPassword());
        user.setUsername(userDetailsRequest.getUsername());
        user.setCreatedAt(new Date());
        return user;
    }
    public static UserDetailsResponse entityToUserResponse(User user){
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        userDetailsResponse.setEmail(user.getEmail());
        userDetailsResponse.setName(user.getName());
        userDetailsResponse.setUsername(user.getUsername());
        userDetailsResponse.setCreatedAt(user.getCreatedAt());
        return userDetailsResponse;
    }
}
