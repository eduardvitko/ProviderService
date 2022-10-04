//package com.providerservice.model;
//
//import lombok.*;
//import lombok.experimental.Accessors;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Set;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
//@Accessors(chain = true)
//@Entity(name = "services")
//public class ServiceEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(unique = true, nullable = false, updatable = false)
//    private String name;
//    @OneToMany
//    private List<TariffEntity> tariffs;
//    @Column(name = "isActive")
//    private boolean isActive;
//    @Column(name = "created")
//    private LocalDateTime created;
//    @Column(name = "updated")
//    private LocalDateTime updated;
//
//}
