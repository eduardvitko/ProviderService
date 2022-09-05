package com.providerservice.dto;

import com.providerservice.model.ServiceType;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TariffDto {
    private int id;

    private String name;

    private ServiceType type;

    private int pricePerDay;

    private boolean isActive;

    private LocalDateTime created;

    private LocalDateTime updated;
}
