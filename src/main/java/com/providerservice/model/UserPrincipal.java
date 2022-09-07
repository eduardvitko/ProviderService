package com.providerservice.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class UserPrincipal implements UserDetails {
    private CustomerEntity customerEntity;
    public UserPrincipal(CustomerEntity customerEntity) {
        this.customerEntity= customerEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  stream(this.customerEntity.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return customerEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return customerEntity.getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return customerEntity.isNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return customerEntity.isActive();
    }
}
