package com.providerservice.model;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = false, nullable = false, updatable = false)
    private String firstName;
    @Column(unique = false, nullable = false, updatable = false)
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
    private String role;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime updated;
    @Column
    private int balance;
}
