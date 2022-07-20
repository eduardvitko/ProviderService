package com.providerservice.services;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDto registration(CustomerRequestDto customerRequestDto);

    void delete(Integer id);

    CustomerDto findCustomerByPhoneNumber(String phoneNumber);

    CustomerDto findCustomerByID(Integer id);

    List<CustomerDto> findAllCustomers();

}
