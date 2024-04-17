package com.javadev.wastemanageraddressservice.controller;

import com.javadev.wastemanageraddressservice.model.dto.WasteManagerAddressEntityDto;
import com.javadev.wastemanageraddressservice.service.WasteManagerAddressEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/waste-manager-address")
public class WasterManagerAdressController {

    private final WasteManagerAddressEntityService wasteManagerAddressEntityService;

    public WasterManagerAdressController(WasteManagerAddressEntityService wasteManagerAddressEntityService) {
        this.wasteManagerAddressEntityService = wasteManagerAddressEntityService;
    }

    @GetMapping("/{wasteManagerAddressId}")
    public ResponseEntity<WasteManagerAddressEntityDto>  findById(@PathVariable long wasteManagerAddressId) {
        return  wasteManagerAddressEntityService.findById(wasteManagerAddressId);
    }

    @PostMapping
    public ResponseEntity<WasteManagerAddressEntityDto> create(@RequestBody WasteManagerAddressEntityDto wasteManagerAddressEntityDto) {

        return (ResponseEntity<WasteManagerAddressEntityDto>) wasteManagerAddressEntityService.create(wasteManagerAddressEntityDto);
    }
}
