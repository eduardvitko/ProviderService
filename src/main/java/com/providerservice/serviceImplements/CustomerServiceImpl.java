package com.providerservice.serviceImplements;


import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;

import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.repositories.CustomerRepository;
import com.providerservice.repositories.RoleRepositories;
import com.providerservice.services.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
//@Qualifier("userDetailsService")
public class CustomerServiceImpl implements CustomerService {
//    @Resource
//    private CustomerMapper customerMapper;
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private RoleRepositories roleRepositories;
//    @Resource
//    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    private CustomerService customerService;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public CustomerEntity registration(CustomerEntity customerEntity) {
        log.info("Saving new Customer{} to database", customerEntity.getPhone());
        //customerEntity.getRoles().add(new Role(4,"ADMIN"));
        CustomerEntity customerEntiti = customerRepository.save(customerEntity);

        return customerEntiti;
//        if (customerRequestDto.getPhone() == null || customerRequestDto.getPassword() == null || customerRequestDto.getEmail() == null) {
//            throw new RuntimeException("Value phone is not be empty");
//        }
//        CustomerDto customerDto = customerMapper.conversationToDto(customerRequestDto);
//        System.out.println(customerDto + "DTO");
//        customerDto.setPassword(customerRequestDto.getPassword());
//        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        //customerDto.setRole(new ArrayList<>());
//
//
//        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDto);
//        customerEntity = customerRepository.save(customerEntity);
//        System.out.println(customerEntity + "ENTITY");
//        return customerMapper.convertToDto(customerEntity);

    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role{} to database", role.getRole());
        return roleRepositories.save(role);
    }

    @Override
    public void addRoleToCustomer(String phone, String role) {
        log.info("Adding role{} to customer{}", phone, role);
        CustomerEntity customerEntity = customerRepository.findCustomerEntitiesByPhone(phone);
        Role role1 = roleRepositories.findByRole(role);
        customerEntity.getRoles().add(role1);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerEntity findCustomerByPhoneNumber(String phoneNumber) {
        log.info("Fetching customer{}", phoneNumber);
        CustomerEntity customerEntity = customerRepository.findCustomerEntitiesByPhone(phoneNumber);
        return customerEntity;
    }

    @Override
    public CustomerEntity findCustomerByID(Integer id) {
        log.info("Searching customer{}", id);
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<CustomerEntity> findAllCustomers() {
        log.info("Fetching all customers");
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities;
    }

    @Override
    public CustomerEntity updateProfile(CustomerEntity customerEntity) {

        CustomerEntity newCustomer = customerRepository.save(customerEntity);
        return newCustomer;
    }


}
