package com.providerservice.mapper;

import com.providerservice.dto.ServiceDto;
import com.providerservice.dto.TariffDto;
import com.providerservice.model.ServiceEntity;
import com.providerservice.model.TariffEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Service
public class TariffMapper {

    public Function<TariffEntity, TariffDto> TariffToDto = this::convertTariffDto;
    public Function<TariffDto, TariffEntity> TariffToEntity = this::convertTariffEntity;

    public Function<ServiceEntity, ServiceDto> ServiceToDto = this::convertToServiceDTO;
    public Function<ServiceDto, ServiceEntity> ServiceToEntity = this::convertToServiceEntity;

    public <A, R> Set<R> collectionToSet(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    public <A, R> List<R> collectionToList(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    public TariffEntity convertTariffEntity(TariffDto tariffDto) {
        TariffEntity tariffEntity = new TariffEntity();
        tariffEntity.setId(tariffDto.getId());
        tariffEntity.setName(tariffDto.getName());
        tariffEntity.setType(tariffDto.getType());
        tariffEntity.setPricePerDay(tariffDto.getPricePerDay());
        tariffEntity.setActive(tariffDto.isActive());
        tariffEntity.setCreated(tariffDto.getCreated());
        tariffEntity.setUpdated(tariffDto.getUpdated());

        return tariffEntity;

    }

    public TariffDto convertTariffDto(TariffEntity tariffEntity) {
        TariffDto tariffDto = new TariffDto();
        tariffDto.setId(tariffEntity.getId());
        tariffDto.setName(tariffEntity.getName());
        tariffDto.setType(tariffEntity.getType());
        tariffDto.setPricePerDay(tariffEntity.getPricePerDay());
        tariffDto.setActive(tariffEntity.isActive());
        tariffDto.setCreated(tariffEntity.getCreated());
        tariffDto.setUpdated(tariffEntity.getUpdated());

        return tariffDto;
    }


    public ServiceEntity convertToServiceEntity(ServiceDto serviceDto) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(serviceDto.getId());
        serviceEntity.setName(serviceDto.getName());
        serviceEntity.setTariffs(serviceDto.getTariffs().stream().map(t -> convertTariffEntity(TariffDto.builder().build())).collect(toSet()));
        serviceEntity.setActive(serviceDto.isActive());
        serviceEntity.setCreated(serviceDto.getCreated());
        serviceEntity.setUpdated(serviceDto.getUpdated());

        return serviceEntity;
    }

    public ServiceDto convertToServiceDTO(ServiceEntity serviceEntity) {
        return ServiceDto.builder()
                .id(serviceEntity.getId())
                .name(serviceEntity.getName())
                // .tariffs(serviceEntity.getTariffs().stream().map(this::convertTariffDto).collect(toSet()))
                .isActive(serviceEntity.isActive())
                .created(serviceEntity.getCreated())
                .updated(serviceEntity.getUpdated())
                .build();


    }
}


