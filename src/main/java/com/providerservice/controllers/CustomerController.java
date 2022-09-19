package com.providerservice.controllers;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.serviceImplements.CustomerServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-service")
public class CustomerController {
    @Resource
    private CustomerServiceImpl customerService;

    @PostMapping("/customer/registration")
    public ResponseEntity<CustomerEntity> registration(@RequestBody CustomerEntity customerEntity) {
       URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer-service/customer/registration").toUriString());
        return ResponseEntity.created(uri).body(customerService.registration(customerEntity));
    }
    @PostMapping("/create/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/customer-service/create/role").toUriString());
        return ResponseEntity.created(uri).body(customerService.saveRole(role));
    }
    @PostMapping("/addRoleToUser")
    public ResponseEntity <?>addRoleToUser(@RequestBody RoleToUserForm form){
        customerService.addRoleToCustomer(form.getPhone(), form.getRole());
        return ResponseEntity.ok().build();
    }
    @Data
    static
    class RoleToUserForm{
        private String phone;
        private String role;
    }
    @PutMapping("/customer/update")
    public ResponseEntity<CustomerEntity> updateProfile(@RequestBody CustomerEntity customerEntity){
        return ResponseEntity.ok(customerService.updateProfile(customerEntity));
    }

    @GetMapping("/customer/findCustomerByPhoneNumber")
    public ResponseEntity<CustomerEntity> findCustomerByPhoneNumber(@RequestParam("phone") String phone) {
        return ResponseEntity.ok(customerService.findCustomerByPhoneNumber(phone));
    }

    @GetMapping("/customer/findCustomerByID/{id}")
    public ResponseEntity<CustomerEntity> findCustomerByID(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findCustomerByID(id));
    }

    @GetMapping("/customer/getAllCustomers")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
     //  return ResponseEntity.ok(customerService.findAllCustomers());
        List<CustomerEntity> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, OK);
    }
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
         customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }



