package com.mujidev.punkookms.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mujidev.punkookms.hr.models.Employee;
import com.mujidev.punkookms.hr.repositories.EmployeeRepository;
import com.mujidev.punkookms.utils.FileUploadUtil;

@Service
public class EmployeeService {

    @Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private FileUploadUtil fileUploadUtil;
	
	//Get All Employees
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}	
	
	//Get Employee By Id
	public Employee findById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}	
	
	//Delete Employee
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	//Update Employee
	/* public void save(MultipartFile file, Employee employee) {
		String foto = file.getOriginalFilename();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		employeeRepository.save(employee);
	} */
	
	//Get Employee by username
	public Employee findByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}

	//Get employee by Keyword
	public List<Employee> findByKeyword(String keyword) {
		return employeeRepository.findByKeyword(keyword);
	}

    
}
