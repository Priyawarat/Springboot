package com.prod_ready_feature.demo.client.impl;

import com.prod_ready_feature.demo.advice.ApiResponse;
import com.prod_ready_feature.demo.client.EmployeeClient;
import com.prod_ready_feature.demo.dtos.EmployeDto;
import com.prod_ready_feature.demo.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    private final Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeDto> getAllEmployees() {
        logger.trace("Fetching all employees from the external service");

        try{
            ApiResponse<List<EmployeDto>> employees = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});

            logger.info("Fetched employees: {}", employees.getData());
            return employees.getData();
        }catch (Exception e) {
            logger.error("Error while fetching employees: {}", e.getMessage(), e);
            throw new RuntimeException("Error while fetching employees: " + e.getMessage(), e);
        }
    }

    @Override
    public EmployeDto getEmployeeById(long id) {
        try{
            ResponseEntity<ApiResponse<EmployeDto>> employee = restClient.get()
                    .uri("{id}", id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req,res)-> {
                        logger.error("Employee with ID {} not found.", id);
                        throw new RuntimeException("Employee with ID " + id + " not found.");
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req,res)-> {
                        logger.error("Some Server Error Occurred while fetching employee with ID {}", id);
                        throw new RuntimeException("Some Server Error Occurred while fetching employee with ID " + id);
                    })
                    .toEntity(new ParameterizedTypeReference<>() {});

            // From ResponseEntity, we can get the body, Headers, Status Code, etc.
            // Here we are getting the body which is of type ApiResponse<EmployeDto>
            return employee.getBody().getData();
        }catch (Exception e) {
            throw new RuntimeException("Error while fetching employee with ID " + id + ": " + e.getMessage(), e);
        }
    }

}
