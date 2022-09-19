package com.providerservice.services;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
  CustomerEntity registration(CustomerEntity customerEntity);

    Role saveRole (Role role);

    void addRoleToCustomer(String phone, String role);

    void delete(Integer id);

   CustomerEntity findCustomerByPhoneNumber(String phoneNumber);

    CustomerEntity findCustomerByID(Integer id);

    List<CustomerEntity> findAllCustomers();

    CustomerEntity updateProfile(CustomerEntity customerEntity);


}
