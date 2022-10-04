package com.providerservice.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Accessors(chain = true)
@Entity(name = "tariffs")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, updatable = false)
    private String name;
    @Column(unique = true, nullable = false, updatable = false)
    private ServiceType type;
    @Column(name = "pricePerDay")
    private int pricePerDay;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
}
