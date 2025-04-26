package com.example.curso.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.entities.Producto;
import com.example.curso.services.ProductoServiceImpl;

@RestController
@RequestMapping("/productos/*")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAll(){
		return ResponseEntity.ok(serviceImpl.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Producto> getById(@PathVariable Long id){
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if(optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.orElseThrow());
			
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public ResponseEntity<Producto> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(producto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id) {
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if(optionalProducto.isPresent()) {
			Producto productoDb = optionalProducto.orElseThrow();
			productoDb.setNombre(producto.getNombre());
			productoDb.setDescripcion(producto.getDescripcion());
			productoDb.setPrecio(producto.getPrecio());
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.save(productoDb));
		}
		return ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Producto> deleted (@PathVariable Long id) {
		Optional<Producto> optionalProducto = serviceImpl.getById(id);
		if(optionalProducto.isPresent()) {
			Producto productoDeleted = serviceImpl.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(productoDeleted);

		}
		return ResponseEntity.notFound().build();


	}
	

}
