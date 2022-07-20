package com.providerservice.repositories;

import com.providerservice.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
boolean deleteById(int id);
}
