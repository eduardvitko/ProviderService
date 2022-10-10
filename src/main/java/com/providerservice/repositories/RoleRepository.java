package com.providerservice.repositories;

import com.providerservice.model.ERole;
import com.providerservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
   Optional <Role> findByName(ERole name);
}
