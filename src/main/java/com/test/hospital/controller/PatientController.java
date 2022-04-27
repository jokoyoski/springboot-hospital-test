package com.test.hospital.controller;

import com.test.hospital.dao.Patient;
import com.test.hospital.exceptionfilter.NotAuthorizedException;
import com.test.hospital.exceptionfilter.ResourceNotFoundException;
import com.test.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    PatientService _patientService;
    @GetMapping("/patients/{staffId}")
    public List<Patient> getPatients(@PathVariable(value = "staffId") UUID staffId) throws NotAuthorizedException {
        return _patientService.GetPatients(staffId);
    }

    @GetMapping("/download/{staffId}/{patientId}")
    public ResponseEntity<Resource> getFile(@PathVariable(value = "staffId") UUID staffId, @PathVariable(value = "patientId")  Long patientId) throws NotAuthorizedException, IOException, ResourceNotFoundException {
        String filename = "tutorials.csv";
        InputStreamResource file = new InputStreamResource( _patientService.GetPatientById(staffId,patientId));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @DeleteMapping("/patients/{staffId}/{startDate}/{endDate}")
    public ResponseEntity deletePatient(@PathVariable(value = "staffId") UUID staffId, @PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate) throws NotAuthorizedException, IOException, ResourceNotFoundException {
         _patientService.DeleteRange(startDate,endDate,staffId);
         return ResponseEntity.ok("Patients deleted");
    }




}
