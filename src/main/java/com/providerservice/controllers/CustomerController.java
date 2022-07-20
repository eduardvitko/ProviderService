package com.providerservice.controllers;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping("/customer/registration")
    public ResponseEntity<CustomerDto> registration(@RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.registration(customerRequestDto));
    }
}
