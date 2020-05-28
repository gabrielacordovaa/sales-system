package com.cordovagabriela.system.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cordovagabriela.system.entity.Client;

@RestController
@RequestMapping(value="/users")
public class ClientController {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Client> list = new ArrayList<>();
		Client g = new Client("1", "Geovana", "geovana@gmail.com", sdf.parse("09/09/1998"), "123456");
		Client ga = new Client("2", "Gabriela", "gabriela@gmail.com", sdf.parse("19/06/1997"), "123456");
		
		list.addAll(Arrays.asList(g,ga));
		return ResponseEntity.ok().body(list);
		}
}
