package com.prod_ready_feature.demo.controller;

import com.prod_ready_feature.demo.advice.ApiResponse;
import com.prod_ready_feature.demo.client.EmployeeClient;
import com.prod_ready_feature.demo.dtos.EmployeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final EmployeeClient employeeClient;

    @GetMapping()
    public List<EmployeDto> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeDto getEmployee(@PathVariable Integer id) {
        return employeeClient.getEmployeeById(id);
    }

}
