package com.mujidev.punkookms.ga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujidev.punkookms.ga.models.VehicleHire;
import com.mujidev.punkookms.ga.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
    
    @Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//Get All VehicleHires
	public List<VehicleHire> findAll(){
		return vehicleHireRepository.findAll();
	}	
	
	//Get VehicleHire By Id
	public VehicleHire findById(int id) {
		return vehicleHireRepository.findById(id).orElse(null);
	}	
	
	//Delete VehicleHire
	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
	}
	
	//Update VehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
    }
}
