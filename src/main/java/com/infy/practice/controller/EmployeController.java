package com.infy.practice.controller;

import com.infy.practice.dto.EmployeDto;
import com.infy.practice.entity.EmployeeEntity;
import com.infy.practice.exception.ResourceNotFoundException;
import com.infy.practice.repository.EmployeeRepository;
import com.infy.practice.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeController {

    private final EmployeeService employeeService;

    public EmployeController(EmployeeService service)
    {
        this.employeeService = service;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeDto> getEmployee(@PathVariable(name = "employeeId") Long id)
    {
//        EmployeDto employeDto = employeeService.getEmplyeebyId(id);
//        if(employeDto==null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeDto);
        Optional<EmployeDto> employeDto = employeeService.getEmplyeebyId(id);
        return employeDto.map(employeDto1 -> ResponseEntity.ok(employeDto1))
                .orElseThrow(()->new ResourceNotFoundException("Employee Not Found with Id :"+id));
    }

    /**
     * This handler handle only the exception for this controller
     * If we want to handle exception for all controller then we shift the code to Global Handler.
     */
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFound(NoSuchElementException e)
//    {
//        return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
//    }

    @GetMapping
    public List<EmployeDto> getEmployees(@RequestParam Integer age, @RequestParam(required = false) String sortBy)
    {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeDto createEmployee(@RequestBody @Valid EmployeDto inputDto)
    {
        return employeeService.createEmployee(inputDto);
    }

    @PutMapping(path="/{id}")
    public EmployeDto updateEmployee(@RequestBody EmployeDto inputDto, @PathVariable Long id)
    {
        return employeeService.updateEmployee(inputDto, id);
    }

    @DeleteMapping(path="/{id}")
    public boolean deleteEmployee(@PathVariable Long id)
    {
        return employeeService.deleteEmployee(id);
    }

    @PatchMapping(path="/{id}")
    public EmployeDto updatePartialEmployeData(@RequestBody Map<String,Object> updates, @PathVariable Long id)
    {
        return employeeService.updatePartialEmployeeData(updates,id);
    }

}
