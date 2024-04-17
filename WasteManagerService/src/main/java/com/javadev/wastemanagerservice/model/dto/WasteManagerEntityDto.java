package com.javadev.wastemanagerservice.model.dto;


import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class WasteManagerEntityDto {
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String nif;
    @NonNull
    private WasteManagerAddressEntityDto wasteManagerAddressEntity;
    @NonNull
    private List<WasteCenterAuthorizationEntityDto> listOfWasteCenterAuthorization;
}

