package com.example.MUHUMURE_Equipment_management_system.serviceImpl;

import com.example.MUHUMURE_Equipment_management_system.model.RequestModel;
import com.example.MUHUMURE_Equipment_management_system.model.EquipmentModel;
import com.example.MUHUMURE_Equipment_management_system.repository.RequestRepository;
import com.example.MUHUMURE_Equipment_management_system.repository.EquipmentRepository; // Import Equipment repository
import com.example.MUHUMURE_Equipment_management_system.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private EquipmentRepository equipmentRepository; // Inject EquipmentRepository

    @Override
    public RequestModel submitRequest(RequestModel request) {
        request.setRequestDate(LocalDateTime.now()); // Set the current date and time
        request.setStatus("pending"); // Default status
        return requestRepository.save(request); // Save the request to the database
    }

    @Override
    public List<RequestModel> getAllRequests() {
        return requestRepository.findAll(); // Retrieve all requests from the database
    }

    @Override
    public RequestModel updateRequestStatus(Long id, String status) {
        RequestModel request = requestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found")); // Handle case where request is not found

        if (status.equals("approved")) {
            // Fetch the equipment associated with the request
            EquipmentModel equipment = equipmentRepository.findById(request.getEquipmentId())
                    .orElseThrow(() -> new RuntimeException("Equipment not found"));

            // Check if sufficient quantity is available
            if (equipment.getQuantity() > 0) {
                equipment.setQuantity(equipment.getQuantity() - 1); // Decrease quantity by 1
                equipmentRepository.save(equipment); // Save updated equipment
            } else {
                throw new RuntimeException("Insufficient equipment quantity available");
            }
        }

        request.setStatus(status); // Update the status
        return requestRepository.save(request); // Save the updated request
    }
}