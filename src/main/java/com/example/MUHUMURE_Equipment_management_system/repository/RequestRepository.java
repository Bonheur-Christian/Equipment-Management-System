package com.example.MUHUMURE_Equipment_management_system.repository;

import com.example.MUHUMURE_Equipment_management_system.model.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestModel, Long> {
    // Additional query methods can be defined here if needed
}