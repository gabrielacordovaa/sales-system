package com.cordovagabriela.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cordovagabriela.system.entity.Client;
import com.cordovagabriela.system.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Optional<Client> findById(String id) {
		return repository.findById(id);
	}
	
	public Client findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public boolean authenticate(String id, String username, String password){
		Client client = this.findByEmail(username);
		if(client == null){
			return false;
		}
		else {
			if(password.equals(client.getPassword())) {
				return true;
			}
			else return false;
		}
	}
}
