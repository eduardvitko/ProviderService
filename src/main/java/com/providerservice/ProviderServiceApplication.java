package com.providerservice;




import com.providerservice.model.Role;
import com.providerservice.model.User;
import com.providerservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


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
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(0, "CLIENT"));
            userService.saveRole(new Role(0, "MANAGER"));
            userService.saveRole(new Role(0, "ADMIN"));

            userService.saveUser(new User(0, "Ivan", "Cheban", "Ivan_Cheban", "+380664127412", "02121980", "ivan_cheban@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));
            userService.saveUser(new User(0, "Peter", "Filonenko", "Fill", "+380632018963", "11051981", "fill@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));
            userService.saveUser(new User(0, "Viktor", "Vitko", "Vito", "+380501024732", "22101982", "vikvit@gmail.com", true, new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0));


            userService.addRoleToUser("Ivan_Cheban", "ADMIN");
            userService.addRoleToUser("Fill", "MANAGER");
            userService.addRoleToUser("Vito", "CLIENT");


        };
    }



//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
//                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
//        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
//                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}

