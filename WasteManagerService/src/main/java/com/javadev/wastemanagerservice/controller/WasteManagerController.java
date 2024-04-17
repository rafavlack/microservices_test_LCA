package com.javadev.wastemanagerservice.controller;

import com.javadev.wastemanagerservice.model.dto.WasteManagerEntityDto;
import com.javadev.wastemanagerservice.service.WasteManagerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/waste-manager")
public class WasteManagerController {


    private final WasteManagerService wasteManagerService;


    public WasteManagerController(WasteManagerService wasteManagerService) {
        this.wasteManagerService = wasteManagerService;
    }

    @PostMapping
    public ResponseEntity<WasteManagerEntityDto> create(@Valid @RequestBody WasteManagerEntityDto wasteManagerEntityDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Los datos proporcionados no son válidos");
        }

        return (ResponseEntity<WasteManagerEntityDto>) wasteManagerService.create(wasteManagerEntityDto, bindingResult);
    }

    @PutMapping
    public ResponseEntity<WasteManagerEntityDto> update(@Valid @RequestBody WasteManagerEntityDto wasteManagerEntityDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Los datos proporcionados no son válidos");
        }
        return wasteManagerService.update(wasteManagerEntityDto, bindingResult);
    }

    @GetMapping("/{wasteManagerId}")
    public ResponseEntity<WasteManagerEntityDto>  findById(@PathVariable long wasteManagerId) {
        return  wasteManagerService.findById(wasteManagerId);
    }
}
