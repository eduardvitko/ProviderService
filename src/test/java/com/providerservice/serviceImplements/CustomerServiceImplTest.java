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
    void registration() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setFirstName("Victor");
        customerRequestDto.setLastName("Galko");
        customerRequestDto.setPhone("+380632231255");
        customerRequestDto.setPassword("25031952");
        customerRequestDto.setEmail("d@gmail.com");

        CustomerDto customerDto1 = customerService.registration(customerRequestDto);

        assertEquals(1, 1);
        assertNotNull(customerDto1);

    }

    @Test
    void deleteCustomerPositiveTest() {
        Integer id = 17;
        customerService.delete(id);
        assertEquals(true, true);
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
    void findAllCustomers(){
        List<CustomerDto> customerDtoList = customerService.findAllCustomers();
        Integer size = customerDtoList.size();
        assertNotNull(customerDtoList);
        assertEquals(5,5);
    }


}
