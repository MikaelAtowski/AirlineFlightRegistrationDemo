package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curso.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	
	
	
}
