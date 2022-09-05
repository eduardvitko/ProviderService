package com.providerservice.model;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Accessors(chain = true)
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, updatable = false)
    private String firstName;
    @Column(unique = true, nullable = false, updatable = false)
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    private String phone;
    @Column(unique = true, nullable = false, updatable = false)
    private String password;
    @Column(unique = true, nullable = false, updatable = false)
    private String email;
    @Column
    private boolean isActive;
    @Column
    private boolean isNotLocked;
    @Column
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    @Column
    private String[] authorities;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime updated;
    @Column
    private int balance;
}
