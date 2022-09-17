package com.providerservice.mapper;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.dto.RoleDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.repositories.RoleRepositories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class CustomerMapper {
    @Resource
    private RoleRepositories roleRepositories;

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
        customerEntity.setRoles(customerDto.getRole().stream().map(r -> toRoleEntity(r)).collect(Collectors.toList()));
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
        customerDto.setRole(customerEntity.getRoles().stream().map(r -> toRoleDto(r)).collect(Collectors.toList()));
        customerDto.setCreated(customerEntity.getCreated());
        customerDto.setUpdated(customerEntity.getUpdated());
        customerDto.setBalance(customerEntity.getBalance());
        return customerDto;
    }
    public CustomerDto conversationToDto(CustomerRequestDto customerRequestDto){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerRequestDto.getId());
        customerDto.setFirstName(customerRequestDto.getFirstName());
        customerDto.setLastName(customerRequestDto.getLastName());
        customerDto.setPhone(customerRequestDto.getPhone());
        customerDto.setPassword(customerRequestDto.getPassword());
        customerDto.setEmail(customerRequestDto.getEmail());
        customerDto.setActive(true);
        customerDto.setRole(Arrays.asList(new RoleDto(0,"CLIENT")));
        customerDto.setCreated(LocalDateTime.now());
        customerDto.setUpdated(LocalDateTime.now());
        customerDto.setBalance(0);
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
        customerEntity.setRoles(new ArrayList<>());
        customerEntity.setCreated(LocalDateTime.now());
        customerEntity.setUpdated(LocalDateTime.now());
        customerEntity.setBalance(0);
        return customerEntity;

    }
    public RoleDto toRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(roleDto.getRole());
        return roleDto;
    }

    public Role toRoleEntity(RoleDto role) {
      Role role1 = new Role();
      role1.setId(role.getId());
      role1.setRole(role.getRole());
        return role1;
    }
}
