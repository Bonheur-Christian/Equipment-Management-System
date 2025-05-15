package com.example.MUHUMURE_Equipment_management_system.repository;

import com.example.MUHUMURE_Equipment_management_system.model.ReturnModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<ReturnModel, Long> {
    // Additional query methods can be defined here if needed
}