package com.example.MUHUMURE_Equipment_management_system.service;

import com.example.MUHUMURE_Equipment_management_system.model.ReturnModel;
import java.util.List;

public interface ReturnService {
    ReturnModel submitReturn(ReturnModel returnModel);
    List<ReturnModel> getAllReturns();
}
