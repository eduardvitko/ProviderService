package com.providerservice.model;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, updatable = false)
    private String firstName;
    @Column(unique = true, nullable = false, updatable = false)
    private String lastName;
    @Column(unique = true, nullable = false, updatable = false)
    private String username;
    @Column(unique = true, nullable = false, updatable = false)
    private String phone;
    @Column(unique = true, nullable = false, updatable = false)
    private String password;
    @Column(unique = true, nullable = false, updatable = false)
    private String email;
    @Column(name = "isActive")
    private boolean isActive;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "user_roles",
    joinColumns= @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles =new HashSet<>();
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @Column(name = "balance")
    private int balance;
}
