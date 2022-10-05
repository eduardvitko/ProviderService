package com.providerservice.services;


import com.providerservice.model.Role;
import com.providerservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    User saveUser (User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();


}
