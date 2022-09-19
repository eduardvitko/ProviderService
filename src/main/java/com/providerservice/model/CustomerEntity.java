package com.providerservice.model;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="user_roles", joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private Collection<Role> roles =new ArrayList<>();
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime updated;
    @Column
    private int balance;
}
