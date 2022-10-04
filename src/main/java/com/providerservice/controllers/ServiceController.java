//package com.providerservice.controllers;
//
//
//import com.providerservice.model.ServiceEntity;
//import com.providerservice.serviceImplements.ServiceServiceImpl;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.OK;
//
//@RestController
//@RequestMapping("/service-service")
//public class ServiceController {
//    @Resource
//    private ServiceServiceImpl serviceService;
//    @PostMapping("/service/create")
//    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity serviceEntity) {
//        return ResponseEntity.ok(serviceService.createService(serviceEntity));
//    }
//    @GetMapping("/service/getAllServices")
//    public ResponseEntity<List<ServiceEntity>> getAllServices() {
//        List<ServiceEntity> services = serviceService.findAll();
//        return new ResponseEntity<>(services, OK);
//    }
//}
