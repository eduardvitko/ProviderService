package com.providerservice.repositories;

import com.providerservice.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
    List<ServiceEntity> findAll();
    ServiceEntity findAllById(int id);
    ServiceEntity findByName(String name);

}
