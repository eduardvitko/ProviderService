package com.providerservice.serviceImplements;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.mapper.CustomerMapper;
import com.providerservice.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static com.providerservice.model.Role.CLIENT;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {
    @Resource
    private CustomerServiceImpl customerService;
    @Resource
    private CustomerMapper customerMapper;


    @Test
    void registration() {
        CustomerRequestDto customerRequestDto =new CustomerRequestDto();
        customerRequestDto.setFirstName("Victor");
        customerRequestDto.setLastName("Kotov");
        customerRequestDto.setPhone("+380632231255");
        customerRequestDto.setPassword("25031952");
        customerRequestDto.setEmail("d@gmail.com");
        
        CustomerDto customerDto1 = customerService.registration(customerRequestDto);
        System.out.println(customerDto1);

        assertEquals(1,1);
        assertNotNull(customerDto1);

    }
}
