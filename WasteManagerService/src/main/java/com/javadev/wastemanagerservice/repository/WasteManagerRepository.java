package com.javadev.wastemanagerservice.repository;

import com.javadev.wastemanagerservice.model.entity.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {
}
