package com.providerservice.controllers;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping("/customer/registration")
    public ResponseEntity<CustomerDto> registration(@RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.registration(customerRequestDto));
    }

    @GetMapping("/customer/findCustomerByPhoneNumber")
    public ResponseEntity<CustomerDto> findCustomerByPhoneNumber(@RequestParam("phone") String phone) {
        return ResponseEntity.ok(customerService.findCustomerByPhoneNumber(phone));
    }

    @GetMapping("/customer/findCustomerByID/{id}")
    public ResponseEntity<CustomerDto> findCustomerByID(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findCustomerByID(id));
    }

    @GetMapping("/customer/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }
//    @DeleteMapping("/customer/delete/{id}")
//    public ResponseEntity<T> deleteCustomer(@PathVariable Integer id){
//        return ResponseEntity.ok(customerService.delete(id));
//    }

}
