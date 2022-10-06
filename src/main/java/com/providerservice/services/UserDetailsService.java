package com.providerservice.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    User loadUserByUserName(String var1) throws UsernameNotFoundException;
}
