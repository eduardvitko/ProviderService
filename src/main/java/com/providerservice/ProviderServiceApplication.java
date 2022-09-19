package com.providerservice;

import com.providerservice.dto.CustomerRequestDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.Role;
import com.providerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceApplication.class, args);

    }

    @Bean
    CommandLineRunner run(CustomerService customerService) {
        return args -> {
            customerService.saveRole(new Role(0, "CLIENT"));
            customerService.saveRole(new Role(0, "MANAGER"));
            customerService.saveRole(new Role(0, "ADMIN"));

            customerService.registration(new CustomerEntity(0, "Ivan", "Cheban", "+380664127412", "02121980", "ivan_cheban@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));
            customerService.registration(new CustomerEntity(0, "Peter", "Filonenko", "+380632018963", "11051981", "fill@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));
            customerService.registration(new CustomerEntity(0, "Viktor", "Vitko", "+380501024732", "22101982", "vikvit@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));


            customerService.addRoleToCustomer("+380664127412", "ADMIN");
            customerService.addRoleToCustomer("+380632018963", "MANAGER");
            customerService.addRoleToCustomer("+380501024732", "CLIENT");
        };
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
