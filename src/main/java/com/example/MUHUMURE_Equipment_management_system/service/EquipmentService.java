package com.example.MUHUMURE_Equipment_management_system.service;

import com.example.MUHUMURE_Equipment_management_system.model.EquipmentModel;

import java.util.List;

public interface EquipmentService {
    List<EquipmentModel> getAllEquipments();
    EquipmentModel addEquipment(EquipmentModel equipment);
    EquipmentModel updateEquipment(Long id, EquipmentModel equipmentDetails);
    void deleteEquipment(Long id);

    EquipmentModel getEquipmentById(Long id);
}