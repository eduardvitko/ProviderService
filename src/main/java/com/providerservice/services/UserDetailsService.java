package com.providerservice.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetailsService loadUserByUserName(String var1) throws UsernameNotFoundException;
}
