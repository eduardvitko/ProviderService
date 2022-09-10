package com.providerservice.repositories;

import com.providerservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface RoleRepositories extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
