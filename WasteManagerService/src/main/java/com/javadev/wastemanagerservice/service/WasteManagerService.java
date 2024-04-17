package com.javadev.wastemanagerservice.service;

import com.javadev.wastemanagerservice.model.dto.WasteCenterAuthorizationEntityDto;
import com.javadev.wastemanagerservice.model.dto.WasteManagerAddressEntityDto;
import com.javadev.wastemanagerservice.model.dto.WasteManagerEntityDto;
import com.javadev.wastemanagerservice.model.entity.WasteCenterAuthorizationEntity;
import com.javadev.wastemanagerservice.model.entity.WasteManagerAddressEntity;
import com.javadev.wastemanagerservice.model.entity.WasteManagerEntity;
import com.javadev.wastemanagerservice.repository.WasteManagerAddressRepository;
import com.javadev.wastemanagerservice.repository.WasteManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Service
public class WasteManagerService {

    private final WasteManagerRepository wasteManagerRepository;
    private final WasteManagerAddressRepository wasteManagerAddressRepository;

    private final RestTemplate restTemplate;

    private final ModelMapper modelMapper;

    public WasteManagerService(WasteManagerRepository wasteManagerRepository, WasteManagerAddressRepository wasteManagerAddressRepository, RestTemplate restTemplate, ModelMapper modelMapper) {
        this.wasteManagerRepository = wasteManagerRepository;
        this.wasteManagerAddressRepository = wasteManagerAddressRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity create(WasteManagerEntityDto wasteManagerEntityDto, BindingResult bindingResult) throws Exception  {

        if (bindingResult.hasErrors()) {
            throw new Exception("Los datos proporcionados no son válidos");
        }

        WasteManagerEntity wasteManagerEntity = modelMapper.map(wasteManagerEntityDto, WasteManagerEntity.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Request-By", "GatewayService");
        HttpEntity<WasteManagerAddressEntityDto> request = new HttpEntity<>(modelMapper.map(wasteManagerEntity.getWasteManagerAddressEntity(), WasteManagerAddressEntityDto.class), headers);

        WasteManagerAddressEntityDto savedAddress = restTemplate.postForObject("http://wasteManagerAddressService-server/api/v1/waste-manager-address", request, WasteManagerAddressEntityDto.class);

        for (WasteCenterAuthorizationEntityDto authorizationDto : wasteManagerEntityDto.getListOfWasteCenterAuthorization()) {
            WasteCenterAuthorizationEntity authorizationEntity = modelMapper.map(authorizationDto, WasteCenterAuthorizationEntity.class);
            authorizationEntity.setWasteManagerEntity(wasteManagerEntity);
            wasteManagerEntity.getListOfWasteCenterAuthorization().add(authorizationEntity);
        }

        Optional<WasteManagerAddressEntity> existingAddress = wasteManagerAddressRepository.findById(savedAddress.getId());

        if (existingAddress.isPresent()) {
            wasteManagerEntity.setWasteManagerAddressEntity(existingAddress.get());
        } else {
            throw new Exception("Dirección no encontrada");
        }

        WasteManagerEntity savedEntity = wasteManagerRepository.save(wasteManagerEntity);

        return ResponseEntity.ok(modelMapper.map(savedEntity, WasteManagerEntityDto.class));
    }


    public ResponseEntity<WasteManagerEntityDto> update(WasteManagerEntityDto wasteManagerEntityDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Los datos proporcionados no son válidos");
        }

        WasteManagerEntity wasteManagerEntity = wasteManagerRepository.save(modelMapper.map(wasteManagerEntityDto, WasteManagerEntity.class));

        return ResponseEntity.ok(modelMapper.map(wasteManagerEntity, WasteManagerEntityDto.class));
    }

    public ResponseEntity<WasteManagerEntityDto> findById(long id) {
        Optional<WasteManagerEntity> wasteManagerEntity = wasteManagerRepository.findById(id);
        if (wasteManagerEntity.isPresent()) {

            WasteManagerEntityDto wasteManagerEntityDto = modelMapper.map(wasteManagerEntity.get(), WasteManagerEntityDto.class);
            return ResponseEntity.ok(wasteManagerEntityDto);
        } else {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "not_value");

            return new ResponseEntity("El elemento no existe", headers, HttpStatus.NOT_FOUND);
        }
    }


}


