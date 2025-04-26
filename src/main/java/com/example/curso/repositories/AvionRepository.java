package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.Avion;

public interface AvionRepository extends JpaRepository<Avion,Long> {
	
}
