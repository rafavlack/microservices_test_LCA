package com.javadev.wastemanageraddressservice.repository;

import com.javadev.wastemanageraddressservice.model.entity.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WasteManagerAddressEntityRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
}
