package com.providerservice.model;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.RoleDto;
import com.providerservice.serviceImplements.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
       CustomerDto customerDto = customerService.findCustomerByPhoneNumber(phone);
        System.out.println(customerDto);
        if (customerDto!= null) {
            List<GrantedAuthority> authorities = getUserAuthority((List<RoleDto>) customerDto.getRole());
            return buildUserForAuthentication(customerDto, authorities);
        } else {
            throw new UsernameNotFoundException("user with email " + phone + " does not exist.");
        }
    }
    private List<GrantedAuthority> getUserAuthority(List<RoleDto> userRoles) {
        List<GrantedAuthority> roles = new ArrayList<>();
        userRoles.forEach((role) -> {roles.add(new SimpleGrantedAuthority(role.getRole())); });
        return new ArrayList<GrantedAuthority>(roles);
    }

    private UserDetails buildUserForAuthentication(CustomerDto customerDto, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(customerDto.getPhone(), customerDto.getPassword(), authorities);
    }
}
