package com.providerservice.mapper;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import static com.providerservice.model.Role.CLIENT;


@Service
public class CustomerMapper {
    public CustomerEntity convertToEntity(CustomerDto customerDto){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setPhone(customerDto.getPhone());
        customerEntity.setPassword(customerDto.getPassword());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setActive(customerDto.isActive());
        customerEntity.setRole(customerDto.getRole());
        customerEntity.setCreated(customerDto.getCreated());
        customerEntity.setUpdated(customerDto.getUpdated());
        customerEntity.setBalance(customerDto.getBalance());
        return customerEntity;
    }
    public CustomerDto convertToDto(CustomerEntity customerEntity){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setPhone(customerEntity.getPhone());
        customerDto.setPassword(customerEntity.getPassword());
        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setActive(customerEntity.isActive());
        customerDto.setRole(customerEntity.getRole());
        customerDto.setCreated(customerEntity.getCreated());
        customerDto.setUpdated(customerEntity.getUpdated());
        customerDto.setBalance(customerEntity.getBalance());
        return customerDto;
    }

    public CustomerEntity toCustomerEntity(CustomerRequestDto customerRequestDto){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerRequestDto.getFirstName());
        customerEntity.setLastName(customerRequestDto.getLastName());
        customerEntity.setPhone(customerRequestDto.getPhone());
        customerEntity.setPassword(customerRequestDto.getPassword());
        customerEntity.setEmail(customerRequestDto.getEmail());
        customerEntity.setActive(true);
        customerEntity.setRole(CLIENT);
        customerEntity.setCreated(LocalDateTime.now());
        customerEntity.setUpdated(LocalDateTime.now());
        customerEntity.setBalance(0);
        return customerEntity;

    }
}
