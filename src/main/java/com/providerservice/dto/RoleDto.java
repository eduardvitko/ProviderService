package com.providerservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RoleDto {
    private  int id;
    private String role;
}
