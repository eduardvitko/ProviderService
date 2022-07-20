package com.providerservice.services;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
   CustomerDto registration (CustomerRequestDto customerRequestDto);

   boolean delete(int id);

}
