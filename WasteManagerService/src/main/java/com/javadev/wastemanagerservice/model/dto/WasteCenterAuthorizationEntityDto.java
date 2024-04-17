package com.javadev.wastemanagerservice.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class WasteCenterAuthorizationEntityDto {

    private Long id;
    @NonNull
    private String authorizationNumber;
}
