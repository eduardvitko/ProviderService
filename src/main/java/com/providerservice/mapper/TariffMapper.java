package com.providerservice.mapper;

import com.providerservice.dto.CustomerDto;
import com.providerservice.dto.ServiceDto;
import com.providerservice.dto.TariffDto;
import com.providerservice.model.CustomerEntity;
import com.providerservice.model.ServiceEntity;
import com.providerservice.model.TariffEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TariffMapper {


    public static TariffEntity convertTariffEntity(TariffDto tariffDto) {
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

    public static TariffDto convertTariffDto(TariffEntity tariffEntity){
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


}
