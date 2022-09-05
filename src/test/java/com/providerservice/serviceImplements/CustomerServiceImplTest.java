package com.providerservice.serviceImplements;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.exceptions.CustomerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void registrationNegativeNotPhoneTest() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setFirstName("Victor");
        customerRequestDto.setLastName("Galko");
        customerRequestDto.setPhone(null);
        customerRequestDto.setPassword("25031952");
        customerRequestDto.setEmail("d@gmail.com");

        assertThatThrownBy(() ->customerService.registration(null)).isInstanceOf(RuntimeException.class);
    }
    @Test
    void registrationNegativeNotEmailTest() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setFirstName("Victor");
        customerRequestDto.setLastName("Galko");
        customerRequestDto.setPhone("+380501274320");
        customerRequestDto.setPassword("25031952");
        customerRequestDto.setEmail(null);

        assertThatThrownBy(() ->customerService.registration(null)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void deleteCustomerPositiveTest() {
//        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Ivan","Budko","+380995214036","00264567","budko@gmail.com");
//        CustomerDto customerDto = customerService.registration(customerRequestDto);
//        Integer id = customerService.findCustomerByPhoneNumber("+380995214036").getId();
        customerService.delete(33);

    }

    @Test
    void findCustomerByPhoneNumberPositiveTest() {
        CustomerDto customerDto = customerService.findCustomerByPhoneNumber("+380955992668");
        int id = customerService.findCustomerByPhoneNumber("+380955992668").getId();
        assertEquals(1,1);
        assertThat(customerDto.getPhone()).isEqualTo("+380955992668");
        assertNotNull(customerDto);
    }
    @Test
    void findCustomerByIDPositiveTest(){
        CustomerDto customerDto = customerService.findCustomerByID(2);
        assertThat(customerDto.getPhone()).isEqualTo("+380667475521");
        assertNotNull(customerDto);
    }
//    @Test
//    void findAllCustomersPositiveTest(){
//        List<CustomerDto> customerDtoList = customerService.findAllCustomers();
//        Integer size = customerDtoList.size();
//        assertNotNull(customerDtoList);
//        assertEquals(size,size);
//    }
//    @Test
//    void updateProfileCustomerPositiveTest(){
////        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Ivan","Budko","+380995214036","00264567","budko@gmail.com");
////        CustomerDto customerDto = customerService.registration(customerRequestDto);
////        Integer id = customerService.findCustomerByPhoneNumber("+380995214036").getId();
//        CustomerDto customer = new CustomerDto(33,"Ricky","Martin","+380669693698","12081968","martin@gmail.com",
//                true,"CLIENT", LocalDateTime.now(),LocalDateTime.now(),100);
//        CustomerDto newCustomer = customerService.updateProfile(customer);
//        Integer newID = customerService.findCustomerByPhoneNumber("+380669693698").getId();
////        System.out.println(newID);
////        assertEquals(id,newID);
//        assertNotNull(newCustomer);
//
//        //customerService.delete(id);
//    }



}
