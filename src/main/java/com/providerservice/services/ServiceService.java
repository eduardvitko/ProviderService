package com.providerservice.services;

import com.providerservice.dto.ServiceDto;
import com.providerservice.model.ServiceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceService {
    ServiceEntity createService(ServiceDto serviceDto);
    List<ServiceDto>findAll();
}
