package com.javadev.wastemanageraddressservice.service;

import com.javadev.wastemanageraddressservice.model.dto.WasteManagerAddressEntityDto;
import com.javadev.wastemanageraddressservice.model.entity.WasteManagerAddressEntity;
import com.javadev.wastemanageraddressservice.repository.WasteManagerAddressEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.Optional;

@Service
public class WasteManagerAddressEntityService {

    private final WasteManagerAddressEntityRepository wasteManagerAddressEntityRepository;
    private final ModelMapper modelMapper;

    public WasteManagerAddressEntityService(WasteManagerAddressEntityRepository wasteManagerAddressEntityRepository, ModelMapper modelMapper) {
        this.wasteManagerAddressEntityRepository = wasteManagerAddressEntityRepository;
        this.modelMapper = modelMapper;
    }


    public ResponseEntity<?> create(WasteManagerAddressEntityDto wasteManagerAddressEntityDto) {

        try {
            WasteManagerAddressEntity wasteManagerAddressEntity = modelMapper.map(wasteManagerAddressEntityDto, WasteManagerAddressEntity.class);
            wasteManagerAddressEntity.setCreatedDate(new Date());
            wasteManagerAddressEntity.setLastModifiedDate(new Date());

            WasteManagerAddressEntity wasteManagerAddressEntityResult = wasteManagerAddressEntityRepository.save(wasteManagerAddressEntity);

            return new ResponseEntity<>(modelMapper.map(wasteManagerAddressEntityResult ,WasteManagerAddressEntityDto.class), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>("Ocurrió un error al crear WasteManagerAddressEntity: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<WasteManagerAddressEntityDto> findById(long wasteManagerAddressId) {

        Optional<WasteManagerAddressEntity> wasteManagerAddressEntity = wasteManagerAddressEntityRepository.findById(wasteManagerAddressId);
        if (wasteManagerAddressEntity.isPresent()) {

            WasteManagerAddressEntityDto wasteManagerAddressEntityDto = modelMapper.map(wasteManagerAddressEntity.get(), WasteManagerAddressEntityDto.class);
            return ResponseEntity.ok(wasteManagerAddressEntityDto);
        } else {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "not_value");

            return new ResponseEntity("El elemento no existe", headers, HttpStatus.NOT_FOUND);
        }
    }
}



