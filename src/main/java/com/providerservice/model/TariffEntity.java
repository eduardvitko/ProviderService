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
@Entity
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, updatable = false)
    private String name;
    @Column(unique = true, nullable = false, updatable = false)
    private ServiceType type;
    @Column
    private int pricePerDay;
    @Column
    private boolean isActive;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime updated;
}
