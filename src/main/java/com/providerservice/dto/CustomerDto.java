package com.providerservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDto {
    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String password;

    private String email;

    private boolean isActive;

    private boolean isNotLocked;
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private String[] authorities;

    private LocalDateTime created;

    private LocalDateTime updated;

    private int balance;
}
