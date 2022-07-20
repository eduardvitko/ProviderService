package com.providerservice.repositories;

import com.providerservice.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

   void deleteCustomerById(Integer id);

   CustomerEntity findCustomerEntitiesByPhone(String phone);

   CustomerEntity findCustomerById(Integer id);

   List<CustomerEntity> findAllCustomers();
}
