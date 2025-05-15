package com.example.MUHUMURE_Equipment_management_system.serviceImpl;

import com.example.MUHUMURE_Equipment_management_system.model.EquipmentModel;
import com.example.MUHUMURE_Equipment_management_system.repository.EquipmentRepository;
import com.example.MUHUMURE_Equipment_management_system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<EquipmentModel> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    @Override
    public EquipmentModel addEquipment(EquipmentModel equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public EquipmentModel updateEquipment(Long id, EquipmentModel equipmentDetails) {
        EquipmentModel equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        equipment.setName(equipmentDetails.getName());
        equipment.setType(equipmentDetails.getType());
        equipment.setQuantity(equipmentDetails.getQuantity());
        equipment.setStatus(equipmentDetails.getStatus());
        equipment.setLocation(equipmentDetails.getLocation());
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public EquipmentModel getEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
    }

}