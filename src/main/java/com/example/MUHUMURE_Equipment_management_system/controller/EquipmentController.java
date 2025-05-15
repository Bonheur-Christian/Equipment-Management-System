package com.example.MUHUMURE_Equipment_management_system.controller;

import com.example.MUHUMURE_Equipment_management_system.model.EquipmentModel;
import com.example.MUHUMURE_Equipment_management_system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/all-equipments")
    public List<EquipmentModel> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/{id}")  // New method to get equipment by ID
    public ResponseEntity<EquipmentModel> getEquipmentById(@PathVariable Long id) {
        EquipmentModel equipment = equipmentService.getEquipmentById(id);

        return ResponseEntity.ok(equipment);
    }

    @PostMapping("/add-equipment")
    public ResponseEntity<EquipmentModel> addEquipment(@RequestBody EquipmentModel equipment) {
        EquipmentModel newEquipment = equipmentService.addEquipment(equipment);
        return ResponseEntity.status(201).body(newEquipment);
    }

    @PutMapping("/update-equipment/{id}")
    public ResponseEntity<EquipmentModel> updateEquipment(@PathVariable Long id, @RequestBody EquipmentModel equipmentDetails) {
        EquipmentModel updatedEquipment = equipmentService.updateEquipment(id, equipmentDetails);
        return ResponseEntity.ok(updatedEquipment);
    }

    @DeleteMapping("/delete-equipment/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }
}