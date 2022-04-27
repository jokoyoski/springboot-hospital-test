package com.test.hospital.repository;

import com.test.hospital.dao.Patient;
import com.test.hospital.dao.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
    public interface PatientRepository  extends JpaRepository<Patient, Long> {
    @Query(value = "SELECT * FROM patient where age > 20", nativeQuery = true)
    List<Patient> findPatientsByAge();

    @Query(value = "select *  FROM patient where last_visit_date between  ?1 AND  ?2", nativeQuery = true)
      List<Patient> DeleteRange(String startDate , String endDate);
    }


