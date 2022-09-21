//package com.providerservice.security;
//
//import com.providerservice.model.CustomerEntity;
//import com.providerservice.model.Role;
//import com.providerservice.serviceImplements.CustomerServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private CustomerServiceImpl customerService;
//
//    @Override
//    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
//       CustomerEntity customerEntity = customerService.findCustomerByPhoneNumber(phone);
//        System.out.println(customerEntity);
//        if (customerEntity!= null) {
//            List<GrantedAuthority> authorities = getUserAuthority((List<Role>) customerEntity.getRoles());
//            return buildUserForAuthentication(customerEntity, authorities);
//        } else {
//            throw new UsernameNotFoundException("user with email " + phone + " does not exist.");
//        }
//    }
//    private List<GrantedAuthority> getUserAuthority(List<Role> userRoles) {
//        List<GrantedAuthority> roles = new ArrayList<>();
//        userRoles.forEach((role) -> {roles.add(new SimpleGrantedAuthority(role.getRole())); });
//        return new ArrayList<GrantedAuthority>(roles);
//    }
//
//    private UserDetails buildUserForAuthentication(CustomerEntity customerDto, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(customerDto.getPhone(), customerDto.getPassword(), authorities);
//    }
//}
