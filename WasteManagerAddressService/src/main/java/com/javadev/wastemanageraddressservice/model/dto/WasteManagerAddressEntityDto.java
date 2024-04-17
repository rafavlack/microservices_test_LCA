package com.javadev.wastemanageraddressservice.model.dto;

import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class WasteManagerAddressEntityDto {

    private Long id;
    @NonNull
    private String direccion;
    private Date lastModifiedDate;
}
