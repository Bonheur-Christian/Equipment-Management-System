package com.example.MUHUMURE_Equipment_management_system.serviceImpl;

import com.example.MUHUMURE_Equipment_management_system.model.ReturnModel;
import com.example.MUHUMURE_Equipment_management_system.repository.ReturnRepository;
import com.example.MUHUMURE_Equipment_management_system.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    @Override
    public ReturnModel submitReturn(ReturnModel returnModel) {
        returnModel.setReturnDate(LocalDateTime.now()); // Set the current date and time
        return returnRepository.save(returnModel); // Save the return to the database
    }

    @Override
    public List<ReturnModel> getAllReturns() {
        return returnRepository.findAll(); // Retrieve all returns from the database
    }
}