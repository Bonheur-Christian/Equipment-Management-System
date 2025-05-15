package com.example.MUHUMURE_Equipment_management_system.serviceImpl;

import com.example.MUHUMURE_Equipment_management_system.model.UserModel;
import com.example.MUHUMURE_Equipment_management_system.repository.UserRepository;
import com.example.MUHUMURE_Equipment_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel signup(UserModel user) {
        // Simple password storage (not secure, use hashing in production)
        return userRepository.save(user);
    }

    @Override
    public UserModel login(String email, String password) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}