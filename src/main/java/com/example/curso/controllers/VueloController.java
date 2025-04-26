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

import com.example.curso.dto.VueloDTO;
import com.example.curso.entities.Vuelo;
import com.example.curso.services.VueloServiceImpl;

@RestController
@RequestMapping("/vuelos/*")
@CrossOrigin(value = "http://localhost:4200")
public class VueloController {
	
	@Autowired
	private VueloServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Vuelo>> getAll(){
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Vuelo> geById(@PathVariable Long id){
		Optional<Vuelo> optionalVuelo = serviceImpl.getById(id);
		if(optionalVuelo.isPresent()) {
			return ResponseEntity.ok(optionalVuelo.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody VueloDTO vuelo){
		StringBuilder errorMessage = new StringBuilder();
		if(vuelo.getAvionId() == null) {
			errorMessage.append("El ID del Avion no puede ser nulo.");
		}
		
		if(vuelo.getOrigenId() == null) {
			errorMessage.append("El Aeropuerto de origen no puede ser nulo.");
		}
		
		if(vuelo.getDestinoId() == null) {
			errorMessage.append("El Aeropuerto de destino no puede ser nulo.");
		}
		
		if(errorMessage.length() > 0) {
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(vuelo));
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody VueloDTO vuelo, @PathVariable Long id){
		Optional<Vuelo> optionalVuelo = serviceImpl.getById(id);
		if(optionalVuelo.isPresent()) {
			Vuelo vueloDb = optionalVuelo.orElseThrow();
			vueloDb = serviceImpl.update(vuelo, id);
			if (vueloDb != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(vueloDb);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Vuelo> delete(@PathVariable Long id){
		Optional<Vuelo> optionalVuelo = serviceImpl.getById(id);
		if(optionalVuelo.isPresent()) {
			Vuelo vueloDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(vueloDeleted);
		}
		return ResponseEntity.notFound().build();
	}
}

















