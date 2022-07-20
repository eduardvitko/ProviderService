package com.providerservice.serviceImplements;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.mapper.CustomerMapper;
import com.providerservice.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

import static com.providerservice.model.Role.CLIENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Resource
    private CustomerServiceImpl customerService;



    @Test
    void registrationPositiveTest() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setFirstName("Victor");
        customerRequestDto.setLastName("Galko");
        customerRequestDto.setPhone("+380632231255");
        customerRequestDto.setPassword("25031952");
        customerRequestDto.setEmail("d@gmail.com");

        CustomerDto customerDto = customerService.registration(customerRequestDto);
        Integer id = customerService.findCustomerByPhoneNumber("+380632231255").getId();

        assertEquals(1, 1);
        assertNotNull(customerDto);

        customerService.delete(id);

    }

    @Test
    void deleteCustomerPositiveTest() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Ivan","Budko","+380995214036","00264567","budko@gmail.com");
        CustomerDto customerDto = customerService.registration(customerRequestDto);
        Integer id = customerService.findCustomerByPhoneNumber("+380995214036").getId();
        customerService.delete(id);

    }

    @Test
    void findCustomerByPhoneNumberPositiveTest() {
        CustomerDto customerDto = customerService.findCustomerByPhoneNumber("+380955992668");
        assertThat(customerDto.getPhone()).isEqualTo("+380955992668");
        assertNotNull(customerDto);
    }
    @Test
    void findCustomerByIDPositiveTest(){
        CustomerDto customerDto = customerService.findCustomerByID(2);
        assertThat(customerDto.getPhone()).isEqualTo("+380667475521");
        assertNotNull(customerDto);
    }
    @Test
    void findAllCustomersPositiveTest(){
        List<CustomerDto> customerDtoList = customerService.findAllCustomers();
        Integer size = customerDtoList.size();
        assertNotNull(customerDtoList);
        assertEquals(5,size);
    }



}
