package com.example.MUHUMURE_Equipment_management_system.service;

import com.example.MUHUMURE_Equipment_management_system.model.RequestModel;

import java.util.List;

public interface RequestService {
    RequestModel submitRequest(RequestModel request);
    List<RequestModel> getAllRequests();
    RequestModel updateRequestStatus(Long id, String status);
}