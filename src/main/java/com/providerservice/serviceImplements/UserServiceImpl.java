package com.providerservice.serviceImplements;

import com.providerservice.model.Role;
import com.providerservice.model.User;
import com.providerservice.repositories.RoleRepositories;
import com.providerservice.repositories.UserRepository;
import com.providerservice.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
   @Resource
    private final UserRepository userRepository;
    @Resource
    private final RoleRepositories roleRepositories;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user{} to database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role{} to database", role.getName());
        return roleRepositories.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role{} to user{}", username, roleName);
        User user = userRepository.findByUsername(username);
        Role role = roleRepositories.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user{}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching allUsers");
        return userRepository.findAll();
    }
}
