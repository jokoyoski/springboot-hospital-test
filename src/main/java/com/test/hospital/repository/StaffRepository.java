package com.test.hospital.repository;

import com.test.hospital.dao.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffRepository  extends JpaRepository<Staff, Long> {
    Staff findByUUID(UUID uuid);
}
