package com.test.hospital.controller;

import com.test.hospital.dao.Patient;
import com.test.hospital.dto.Staff;
import com.test.hospital.services.PatientService;
import com.test.hospital.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StaffConroller {
    @Autowired
    StaffService _staffService;
    @PostMapping ("/staff")
    public Staff SaveStaff(@RequestBody Staff staff) throws Exception {

        return this._staffService.AddStaff(staff);
    }

    @PutMapping ("/staff")
    public Staff UpdateStaff(@RequestBody Staff staff) throws Exception {

        return this._staffService.UpdateStaff(staff);
    }
}
