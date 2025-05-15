package com.example.MUHUMURE_Equipment_management_system.service;

import com.example.MUHUMURE_Equipment_management_system.model.UserModel;


public interface UserService {
    UserModel signup(UserModel user);
    UserModel login(String email, String password);
}