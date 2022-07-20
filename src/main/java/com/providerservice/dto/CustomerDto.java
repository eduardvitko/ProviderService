package com.providerservice.dto;

import com.providerservice.model.Role;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
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

//    @NotEmpty(message = "mandatoryParametersMissing")
//    @NotNull
//    @NotBlank
//    @Pattern(regexp = "^[0-9]{12}$")
    private String phone;

    private String password;

    private String email;

    private boolean isActive;

    private String role;

    private LocalDateTime created;

    private LocalDateTime updated;

    private int balance;
}
