package com.mujidev.punkookms.parameters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mujidev.punkookms.parameters.models.Client;
import com.mujidev.punkookms.parameters.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
	private ClientRepository clientRepository;

	//Get All Clients
	public List<Client> findAll(){
		return clientRepository.findAll();
	}

	//Get Client By Id
	public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	//Delete Client
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}

	//Update Client
	public void save( Client client) {
		clientRepository.save(client);
	}
}
