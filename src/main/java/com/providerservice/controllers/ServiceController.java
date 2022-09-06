package com.providerservice.controllers;

import com.providerservice.model.ServiceEntity;
import com.providerservice.serviceImplements.ServiceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/service-service")
public class ServiceController {
    @Resource
    private ServiceServiceImpl serviceService;
    @PostMapping("/service/create")
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity serviceEntity) {
        return ResponseEntity.ok(serviceService.createService(serviceEntity));
    }
}
