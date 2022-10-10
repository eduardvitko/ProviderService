package com.providerservice.serviceImplements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.providerservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String email;

    @JsonIgnore
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isActive;
    private LocalDateTime created;
    private LocalDateTime updated;
    private  int balance;

    public UserDetailsImpl(int id,String firstName,String lastName, String username, String phone,String email, boolean isActive, String password,
                           Collection<? extends GrantedAuthority> authorities,LocalDateTime created,LocalDateTime updated,int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.isActive = isActive;
        this.password = password;
        this.authorities = authorities;
        this.created =created;
        this.updated = updated;
        this.balance = balance;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPhone(),
                user.getEmail(),
                user.isActive(),
                user.getPassword(),
                authorities,
                user.getCreated(),
                user.getUpdated(),
                user.getBalance());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
