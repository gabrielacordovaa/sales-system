package com.cordovagabriela.system.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cordovagabriela.system.entity.Client;
import com.cordovagabriela.system.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Client g = new Client(null, "Geovana", "geovana@gmail.com", sdf.parse("09/09/1998"), "123456");
		Client ga = new Client(null, "Gabriela", "gabriela@gmail.com", sdf.parse("19/06/1997"), "123456");
	
		clientRepository.saveAll(Arrays.asList(g,ga));
		
	}
	
	
}
