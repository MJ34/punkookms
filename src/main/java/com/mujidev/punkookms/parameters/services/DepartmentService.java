package com.mujidev.punkookms.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujidev.punkookms.parameters.models.Department;
import com.mujidev.punkookms.parameters.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    //Get All Departments
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    //Get Department By Id
    public Department findById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    //Delete Department
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    //Update Department
    public void save( Department department) {
        departmentRepository.save(department);
    }
}
