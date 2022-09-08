package com.mujidev.punkookms.hr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.hr.models.EmployeeType;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
    
}
