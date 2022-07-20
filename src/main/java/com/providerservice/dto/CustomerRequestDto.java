package com.providerservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerRequestDto {
    private String firstName;

    private String lastName;

    private String phone;

    private String password;

    private String email;
}
