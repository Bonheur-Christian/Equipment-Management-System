package com.example.MUHUMURE_Equipment_management_system.repository;

import com.example.MUHUMURE_Equipment_management_system.model.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {
}