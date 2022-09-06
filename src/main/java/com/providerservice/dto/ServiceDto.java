package com.providerservice.dto;

import com.providerservice.model.TariffEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ServiceDto {
    private int id;

    private String name;

    private List<TariffEntity> tariffs;

    private boolean isActive;

    private LocalDateTime created;

    private LocalDateTime updated;
}
