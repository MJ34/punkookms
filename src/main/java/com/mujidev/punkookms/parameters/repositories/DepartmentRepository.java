package com.mujidev.punkookms.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mujidev.punkookms.parameters.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    
}
