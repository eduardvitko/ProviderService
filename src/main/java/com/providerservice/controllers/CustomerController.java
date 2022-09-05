package com.providerservice.controllers;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping("/customer/registration")
    public ResponseEntity<CustomerDto> registration(@RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.ok(customerService.registration(customerRequestDto));
    }
    @PutMapping("/customer/update")
    public ResponseEntity<CustomerDto> updateProfile(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateProfile(customerDto));
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
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.findAllCustomers());
        List<CustomerEntity> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, OK);
    }
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
         customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
