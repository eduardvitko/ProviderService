package com.providerservice.serviceImplements;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.mapper.CustomerMapper;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.repositories.CustomerRepository;
import com.providerservice.services.CustomerService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto registration(CustomerRequestDto customerRequestDto) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerRequestDto);
        CustomerEntity customerEntity1 = customerRepository.save(customerEntity);
        customerEntity1.setRole(Role.CLIENT);
        CustomerEntity customerEntity2 = customerRepository.save(customerEntity1);
        return customerMapper.convertToDto(customerEntity2);

    }

    @Override
    public boolean delete(int id) {
        return customerRepository.deleteById(id);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
