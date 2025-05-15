package com.example.MUHUMURE_Equipment_management_system.controller;

import com.example.MUHUMURE_Equipment_management_system.model.UserModel;
import com.example.MUHUMURE_Equipment_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signup(@RequestBody UserModel user) {
        UserModel newUser = userService.signup(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel user) {
        UserModel loggedInUser = userService.login(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).build();
    }
}