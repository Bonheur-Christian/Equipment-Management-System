package com.example.MUHUMURE_Equipment_management_system.controller;

import com.example.MUHUMURE_Equipment_management_system.model.ReturnModel;
import com.example.MUHUMURE_Equipment_management_system.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @PostMapping("/submit")
    public ResponseEntity<ReturnModel> submitReturn(@RequestBody ReturnModel returnModel) {
        if(returnModel.getRequestId() == null){
            System.out.println("All fields are required.");
            return ResponseEntity.badRequest().body(null);
        }
        ReturnModel newReturn = returnService.submitReturn(returnModel);
        return ResponseEntity.status(201).body(newReturn); // Return a 201 Created response
    }

    @GetMapping("/all")
    public List<ReturnModel> getAllReturns() {
        return returnService.getAllReturns(); // Retrieve all returns
    }
}