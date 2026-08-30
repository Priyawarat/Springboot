package com.priye.jpa.controller;

import com.priye.jpa.dto.PatientInfo;
import com.priye.jpa.entity.Patient;
import com.priye.jpa.repository.PatientRepository;
import com.priye.jpa.service.PatientProjection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;


    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/projection")
    public List<PatientInfo> getAllPatientsProjection() {
//        return patientRepository.findAllProjected();
        return patientRepository.getDtoProjection();
    }
}
