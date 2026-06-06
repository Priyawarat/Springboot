package com.infy.practice.service;

import com.infy.practice.dto.EmployeDto;
import com.infy.practice.entity.EmployeeEntity;
import com.infy.practice.exception.ResourceNotFoundException;
import com.infy.practice.repository.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeDto> getEmplyeebyId(Long id) {
//        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
//        return entity.map(employeeEntity -> modelMapper.map(employeeEntity,EmployeDto.class));

        return employeeRepository.findById(id).map(employeeEntity ->  modelMapper.map(employeeEntity,EmployeDto.class));
    }

    public List<EmployeDto> getAllEmployee() {
        List<EmployeeEntity> list = employeeRepository.findAll();
           return list.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeDto.class))
                .toList();

    }

    public EmployeDto createEmployee(EmployeDto inputDto) {
        EmployeeEntity entity = modelMapper.map(inputDto,EmployeeEntity.class);
        EmployeeEntity saveEntity = employeeRepository.save(entity);
        return modelMapper.map(saveEntity,EmployeDto.class);
    }

    public EmployeDto updateEmployee(EmployeDto inputDto, Long id) {
        boolean isExists = employeeRepository.existsById(id);
        if(!isExists) throw new ResourceNotFoundException("Employe not found with id : "+id);
        EmployeeEntity entity = modelMapper.map(inputDto,EmployeeEntity.class);
        entity.setId(id);
        EmployeeEntity saveEntity = employeeRepository.save(entity);
        return modelMapper.map(saveEntity,EmployeDto.class);
    }

    public boolean deleteEmployee(Long id) {
        boolean exits = employeeRepository.existsById(id);
        if(!exits) throw new ResourceNotFoundException("Employe not found with id : "+id);
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeDto updatePartialEmployeeData(Map<String, Object> updates, Long id) {
        boolean exits = employeeRepository.existsById(id);
        if(!exits) throw new ResourceNotFoundException("Employe not found with id : "+id);
        EmployeeEntity entity = employeeRepository.findById(id).orElse(null);
        updates.forEach((field,value)->{
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,entity,value);
        });

        return modelMapper.map(employeeRepository.save(entity),EmployeDto.class);

    }
}
