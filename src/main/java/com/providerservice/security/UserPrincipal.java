//package com.providerservice.security;
//
//import com.providerservice.model.CustomerEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class UserPrincipal implements UserDetails {
//  private CustomerEntity customerEntity;
//
//    public UserPrincipal(CustomerEntity customerEntity) {
//        this.customerEntity = customerEntity;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.customerEntity.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.customerEntity.getPhone();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.customerEntity.isActive();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.customerEntity.isActive();
//    }
//}
