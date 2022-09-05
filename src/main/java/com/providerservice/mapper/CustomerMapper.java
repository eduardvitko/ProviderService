package com.providerservice.mapper;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class CustomerMapper {

    public Function<CustomerEntity, CustomerDto> CustomerToDto = this::convertToDto;
    public Function<CustomerDto, CustomerEntity> CustomerToEntity = this::convertToEntity;

    public <A, R> Set<R> collectionToSet(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    public <A, R> List<R> collectionToList(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    public CustomerEntity convertToEntity(CustomerDto customerDto){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setPhone(customerDto.getPhone());
        customerEntity.setPassword(customerDto.getPassword());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setActive(customerDto.isActive());
        customerEntity.setNotLocked(customerDto.isNotLocked());
        customerEntity.setRole(customerDto.getRole());
        customerEntity.setAuthorities(customerDto.getAuthorities());
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
        customerDto.setNotLocked(customerEntity.isNotLocked());
        customerDto.setRole(customerEntity.getRole());
        customerDto.setAuthorities(customerEntity.getAuthorities());
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
        customerEntity.setNotLocked(true);
        customerEntity.setRole("CLIENT");
        customerEntity.setAuthorities(new String[10]);
        customerEntity.setCreated(LocalDateTime.now());
        customerEntity.setUpdated(LocalDateTime.now());
        customerEntity.setBalance(0);
        return customerEntity;

    }
}
