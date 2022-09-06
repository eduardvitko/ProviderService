package com.providerservice.mapper;

import com.providerservice.dto.ServiceDto;
import com.providerservice.dto.TariffDto;
import com.providerservice.model.ServiceEntity;
import com.providerservice.model.TariffEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


import static com.providerservice.mapper.TariffMapper.convertTariffEntity;
import static java.util.stream.Collectors.*;

@Service
public class ServiceMapper {


   public static ServiceEntity toServiceEntity(ServiceDto serviceDto){
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(serviceDto.getId());
        serviceEntity.setName(serviceDto.getName());
        serviceEntity.setTariffs(serviceDto.getTariffs().stream().map(t -> convertTariffEntity(TariffDto.builder().build())).collect(toList()));
        serviceEntity.setActive(serviceDto.isActive());
        serviceEntity.setCreated(serviceDto.getCreated());
        serviceEntity.setUpdated(serviceDto.getUpdated());

        return serviceEntity;
    }
//    public ServiceDto toServiceDto(ServiceEntity serviceEntity){
//       return new ServiceDto()
//               .setId(serviceEntity.getId())
//               .setName(serviceEntity.getName())
//               .setTariffs(serviceEntity.getTariffs().stream().map(this::convertTariffDto)).collect(toList())
//               .setActive(serviceEntity.isActive())
//               .setCreated(serviceEntity.getCreated())
//               .serviceDto.setUpdated(serviceEntity.getUpdated());
//
//
//    }




}
