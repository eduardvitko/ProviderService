package com.providerservice.serviceImplements;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.exceptions.CustomerException;
import com.providerservice.mapper.CustomerMapper;
import com.providerservice.model.CustomerEntity;
import com.providerservice.repositories.CustomerRepository;
import com.providerservice.services.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private CustomerRepository customerRepository;


    @Override
    public CustomerDto registration(CustomerRequestDto customerRequestDto) {
        if(customerRequestDto.getPhone()==null || customerRequestDto.getPassword()==null||customerRequestDto.getEmail()==null){
            throw new RuntimeException("Value phone is not be empty");
        }
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerRequestDto);
        CustomerEntity customerEntity1 = customerRepository.save(customerEntity);
        return customerMapper.convertToDto(customerEntity1);

    }
    @Override
    public void delete(Integer id) {
     customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto findCustomerByPhoneNumber(String phoneNumber) {
        CustomerEntity customerEntity= customerRepository.findCustomerEntitiesByPhone(phoneNumber);
        return customerMapper.convertToDto(customerEntity);
    }

    @Override
    public CustomerDto findCustomerByID(Integer id) {
        return customerMapper.convertToDto(customerRepository.findCustomerById(id));
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return customerMapper.collectionToList(customerRepository.findAll(),customerMapper.CustomerToDto) ;
    }

    @Override
    public CustomerDto updateProfile(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDto);
        CustomerEntity newCustomer = customerRepository.save(customerEntity);
        return customerMapper.convertToDto(newCustomer);
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
