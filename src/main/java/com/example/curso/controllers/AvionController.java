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

import com.example.curso.dto.AvionDTO;
import com.example.curso.entities.Avion;
import com.example.curso.services.AvionServiceImpl;

@RestController
@RequestMapping("/aviones/*")
@CrossOrigin(value = "http://localhost:4200")
public class AvionController {

	@Autowired
	private AvionServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Avion>> getAll(){
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Avion> getById(@PathVariable Long id){
		Optional<Avion> optionalAvion = serviceImpl.getById(id);
		if(optionalAvion.isPresent()){
			return ResponseEntity.ok(optionalAvion.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AvionDTO avion){
		if(avion.getAerolineaId() == null) {
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("El ID de Aerolinea no puede ser nulo");
			return ResponseEntity.badRequest().body(errorMessage.toString());		
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(avion));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody AvionDTO avion, @PathVariable Long id){
		if(avion.getAerolineaId() == null) {
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("El ID de Aerolinea no puede ser nulo");
			return ResponseEntity.badRequest().body(errorMessage.toString());	
		}
		Avion updateAvion = serviceImpl.update(avion, id);
		if(updateAvion != null) {
			return ResponseEntity.ok(updateAvion);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Avion> delete(@PathVariable Long id){
		Optional<Avion> optionalAvion = serviceImpl.getById(id);
		if(optionalAvion.isPresent()) {
			Avion avionDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(avionDeleted);
		}
		return ResponseEntity.notFound().build();
	}
}
