package com.priye.jpa.repository;

import com.priye.jpa.dto.PatientInfo;
import com.priye.jpa.entity.Patient;
import com.priye.jpa.service.PatientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query("SELECT p.name AS name, p.address AS address, p.phoneNumber AS phoneNumber FROM Patient p")
    List<PatientProjection> findAllProjected();

    @Query("SELECT new com.priye.jpa.dto.PatientInfo(p.id, p.name) FROM Patient p")
    List<PatientInfo> getDtoProjection();

}
