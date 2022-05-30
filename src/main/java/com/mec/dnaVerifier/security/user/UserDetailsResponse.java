package com.mec.dnaVerifier.security.user;

import java.sql.Timestamp;
import java.util.Date;

public class UserDetailsResponse {
    private String name;
    private String username;
    private String email;
    private Date createdAt;

    public UserDetailsResponse() {
    }

    public UserDetailsResponse(String name, String username, String email, Date createdAt) {
        this.name= name;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
