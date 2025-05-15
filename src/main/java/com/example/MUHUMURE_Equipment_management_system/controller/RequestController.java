package com.example.MUHUMURE_Equipment_management_system.controller;

import com.example.MUHUMURE_Equipment_management_system.model.RequestModel;
import com.example.MUHUMURE_Equipment_management_system.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment-requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/submit")
    public ResponseEntity<RequestModel> submitRequest(@RequestBody RequestModel request) {

        if (request.getUserId() == null || request.getEquipmentId() == null) {
            System.out.println("All fields are required.");
            return ResponseEntity.badRequest().body(null); // Return a 400 Bad Request response
        }

        RequestModel newRequest = requestService.submitRequest(request);
        return ResponseEntity.status(201).body(newRequest);
    }

    @GetMapping("/all")
    public List<RequestModel> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PutMapping("/update-status/{id}")
    public ResponseEntity<RequestModel> updateRequestStatus(@PathVariable Long id, @RequestParam String status) {

        if (!status.equals("approved") && !status.equals("rejected")) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request for invalid status
        }

        RequestModel updatedRequest = requestService.updateRequestStatus(id, status);
        return ResponseEntity.ok(updatedRequest);
    }
}