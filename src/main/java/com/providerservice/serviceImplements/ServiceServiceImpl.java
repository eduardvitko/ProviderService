package com.providerservice.serviceImplements;

import com.providerservice.dto.ServiceDto;
import com.providerservice.mapper.TariffMapper;
import com.providerservice.model.ServiceEntity;
import com.providerservice.repositories.ServiceRepository;
import com.providerservice.services.ServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ServiceServiceImpl implements ServiceService {
    @Resource
    private ServiceRepository serviceRepository;
    @Resource
    private TariffMapper tariffMapper;

    @Override
    public ServiceEntity createService(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }
    @Override
    public ServiceEntity findByID(int id) {
        return null;
    }
}
