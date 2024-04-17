package com.javadev.wastemanagerservice.repository;

import com.javadev.wastemanagerservice.model.entity.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WasteManagerAddressRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
}
