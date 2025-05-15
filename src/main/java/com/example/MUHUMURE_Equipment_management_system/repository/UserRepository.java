package com.example.MUHUMURE_Equipment_management_system.repository;

import com.example.MUHUMURE_Equipment_management_system.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
