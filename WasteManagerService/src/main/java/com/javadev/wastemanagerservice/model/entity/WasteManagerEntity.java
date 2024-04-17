package com.javadev.wastemanagerservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WasteManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nif;
    @OneToOne(cascade = CascadeType.ALL)
    private WasteManagerAddressEntity wasteManagerAddressEntity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization  = new ArrayList<>();
    private Boolean isEnabled = Boolean.TRUE;
    private Long version = 0L;
    private Date createdDate;
    private Date lastModifiedDate;
}
