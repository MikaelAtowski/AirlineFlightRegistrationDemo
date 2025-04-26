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

import com.example.curso.dto.AerolineaDTO;
import com.example.curso.entities.Aerolinea;
import com.example.curso.services.AerolineaServiceImpl;

@RestController
@RequestMapping("/aerolineas/*")
@CrossOrigin(value = "http://localhost:4200")
public class AerolineaController {
	@Autowired
	private AerolineaServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Aerolinea>> getAll(){
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	
	//METODO PARA LISTAR CON DTO
	@GetMapping("dto")
	public ResponseEntity<List<AerolineaDTO>> getAllDTO(){
		return ResponseEntity.ok(serviceImpl.listarAerolineasDTO(serviceImpl.getAll()));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Aerolinea> getById(@PathVariable Long id){
		Optional<Aerolinea> optionalAerolinea = serviceImpl.getById(id);
		if(optionalAerolinea.isPresent()) {
			return ResponseEntity.ok(optionalAerolinea.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	//METODO QUE BUSCA POR IATA DAO
	@GetMapping("/iata/{iata}")
	public ResponseEntity<Aerolinea> buscarPorIata(@PathVariable String iata){
		return serviceImpl.buscarPorIata(iata)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Aerolinea> create(@RequestBody Aerolinea aerolinea){
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(aerolinea));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Aerolinea> update(@RequestBody Aerolinea aerolinea, @PathVariable Long id){
		Optional<Aerolinea> optionalAerolinea = serviceImpl.getById(id);
		if(optionalAerolinea.isPresent()) {
			Aerolinea aerolineaDb = optionalAerolinea.orElseThrow();
			aerolineaDb.setNombre(aerolinea.getNombre());
			aerolineaDb.setIata(aerolinea.getIata());
			aerolineaDb.setEstatus(aerolinea.getEstatus());
			aerolineaDb.setFechaFundacion(aerolinea.getFechaFundacion());
			aerolineaDb.setPais(aerolinea.getPais());
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(aerolineaDb));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Aerolinea> delete(@PathVariable Long id){
		Optional<Aerolinea> optionalAerolinea = serviceImpl.getById(id);
		if(optionalAerolinea.isPresent()) {
			Aerolinea aerolineaDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(aerolineaDeleted);
		}
		return ResponseEntity.notFound().build();
	}
		
}
