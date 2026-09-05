package com.prod_ready_feature.demo.client;

import com.prod_ready_feature.demo.advice.ApiResponse;
import com.prod_ready_feature.demo.dtos.EmployeDto;

import java.util.List;

public interface EmployeeClient {

    List<EmployeDto> getAllEmployees();

    EmployeDto getEmployeeById(long id);

}
