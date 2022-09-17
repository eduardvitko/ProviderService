package com.providerservice.serviceImplements;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.dto.RoleDto;
import com.providerservice.mapper.CustomerMapper;
import com.providerservice.model.CustomerEntity;
import com.providerservice.repositories.CustomerRepository;
import com.providerservice.services.CustomerService;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@Qualifier("userDetailsService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomerDto registration(CustomerRequestDto customerRequestDto) {
        if (customerRequestDto.getPhone() == null || customerRequestDto.getPassword() == null || customerRequestDto.getEmail() == null) {
            throw new RuntimeException("Value phone is not be empty");
        }
        CustomerDto customerDto = customerMapper.conversationToDto(customerRequestDto);
        System.out.println(customerDto + "DTO");
        customerDto.setPassword(customerRequestDto.getPassword());
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));


        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDto);
        customerEntity= customerRepository.save(customerEntity);
        System.out.println(customerEntity + "ENTITY");
        return customerMapper.convertToDto(customerEntity);

    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto findCustomerByPhoneNumber(String phoneNumber) {
        CustomerEntity customerEntity = customerRepository.findCustomerEntitiesByPhone(phoneNumber);
        return customerMapper.convertToDto(customerEntity);
    }

    @Override
    public CustomerDto findCustomerByID(Integer id) {
        return customerMapper.convertToDto(customerRepository.findCustomerById(id));
    }

    @Override
    public List<CustomerEntity> findAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities;
    }

    @Override
    public CustomerDto updateProfile(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDto);
        CustomerEntity newCustomer = customerRepository.save(customerEntity);
        return customerMapper.convertToDto(newCustomer);
    }


}
