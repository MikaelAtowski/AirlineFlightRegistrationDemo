package com.example.curso.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Aeropuerto;
import com.example.curso.services.AeropuertoServiceImpl;

@RestController
@RequestMapping("/aeropuertos/*")
@CrossOrigin(value = "http://localhost:4200")
public class AeropuertoController {
	@Autowired
	private AeropuertoServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Aeropuerto>> getAll(){
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Aeropuerto> getById(@PathVariable Long id){
		Optional<Aeropuerto> optionalAeropuerto = serviceImpl.getById(id);
		if(optionalAeropuerto.isPresent()) {
			return ResponseEntity.ok(optionalAeropuerto.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Aeropuerto> create(@RequestBody Aeropuerto aeropuerto){
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(aeropuerto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Aeropuerto> update(@RequestBody Aeropuerto aeropuerto, @PathVariable Long id){
		Optional<Aeropuerto> optionalAeropuerto = serviceImpl.getById(id);
		if(optionalAeropuerto.isPresent()) {
			Aeropuerto aeropuertoDb = optionalAeropuerto.orElseThrow();
			aeropuertoDb.setNombre(aeropuerto.getNombre());
			aeropuertoDb.setCodigo(aeropuerto.getCodigo());
			aeropuertoDb.setLatitud(aeropuerto.getLatitud());
			aeropuertoDb.setLongitud(aeropuerto.getLongitud());
			aeropuertoDb.setPais(aeropuerto.getPais());
			aeropuertoDb.setEstatus(aeropuerto.getEstatus());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(aeropuertoDb));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Aeropuerto> delete(@PathVariable Long id){
		Optional<Aeropuerto> optionalAeropuerto = serviceImpl.getById(id);
		if(optionalAeropuerto.isPresent()) {
			Aeropuerto aeropuertoDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(aeropuertoDeleted);
		}
		return ResponseEntity.notFound().build();
	}
}
