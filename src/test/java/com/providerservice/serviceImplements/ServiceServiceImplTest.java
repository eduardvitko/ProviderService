package com.providerservice.serviceImplements;

import com.providerservice.dto.ServiceDto;

import com.providerservice.model.ServiceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;


@SpringBootTest
class ServiceServiceImplTest {
    @Resource
    private ServiceServiceImpl serviceService;


    @Test
    void createServicePositiveTest() {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("INTERNET");
        serviceEntity.setTariffs(new ArrayList<>());
        serviceEntity.setActive(true);
        serviceEntity.setCreated(LocalDateTime.now());
        serviceEntity.setUpdated(LocalDateTime.now());

        ServiceEntity serviceEntity1 = serviceService.createService(serviceEntity);
        int id = serviceEntity1.getId();
        serviceService.deleteById(id);

    }

}
