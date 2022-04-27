package com.test.hospital.services;

import com.test.hospital.dto.Staff;
import com.test.hospital.exceptionfilter.ResourceNotFoundException;
import com.test.hospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class StaffService {

    @Autowired
    StaffRepository _staffRepository;

    public Staff AddStaff (Staff staff) throws Exception {
        UUID uuid = UUID.randomUUID();
        com.test.hospital.dao.Staff staffDao= new com.test.hospital.dao.Staff();
        staffDao.setName(staff.getName());
        staffDao.setRegistration_date(new Date());
        staffDao.setUuid(uuid);
        var staff_record=_staffRepository.save(staffDao);
        staff.setUuid(uuid);
        staff.setId(staff_record.getId());
        staff.setRegistration_date(staff_record.getRegistration_date());
        return staff;
    }
    public Staff UpdateStaff (Staff staff) throws Exception{
        var staff_record=this._staffRepository.findByUUID(staff.getUuid());  //get by uuid
        if(staff_record==null){
            throw  new ResourceNotFoundException("Employee not found");
        }
        com.test.hospital.dao.Staff staffDao= new com.test.hospital.dao.Staff(); //uuid is unique and should not be updated
        _staffRepository.save(staffDao);
        staff_record.setName(staff.getName());
        return staff;
    }

}
