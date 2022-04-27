package com.test.hospital.services;


import com.test.hospital.dao.Patient;
import com.test.hospital.exceptionfilter.NotAuthorizedException;
import com.test.hospital.exceptionfilter.ResourceNotFoundException;
import com.test.hospital.helper.CSVHelper;
import com.test.hospital.repository.PatientRepository;
import com.test.hospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientRepository _patientRepository;
    @Autowired
    StaffRepository _staffRepository;

    public List<Patient> GetPatients(UUID staffId) throws NotAuthorizedException {
        var staff_record=this._staffRepository.findByUUID(staffId);  //get by uuid
        if(staff_record==null){
            throw  new NotAuthorizedException("Employee not found");
        }
        return _patientRepository.findPatientsByAge();
    }



    public ByteArrayInputStream GetPatientById(UUID staffId,Long patientId) throws NotAuthorizedException, ResourceNotFoundException, IOException {
        var staff_record=this._staffRepository.findByUUID(staffId);  //get by uuid
        if(staff_record==null){
            throw  new NotAuthorizedException("Employee not found");
        }
        var patient=this._patientRepository.findById(patientId);
        if(patient==null){
            throw  new ResourceNotFoundException("Patient not found");
        }
        var csvHelper= CSVHelper.ConvertToCSV(patient.get());

        return csvHelper;
    }
    public void DeleteRange(String startDate, String endDate,UUID staffId) throws NotAuthorizedException, ResourceNotFoundException, IOException {
        var staff_record=this._staffRepository.findByUUID(staffId);  //get by uuid
        if(staff_record==null){
            throw  new NotAuthorizedException("Employee not found");
        }
      var result= this._patientRepository.DeleteRange(startDate,endDate);
        if(result.size()>0){
            _patientRepository.deleteAll(result);
        }

    }




}
