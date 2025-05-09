package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.curso.entities.Aeropuerto;


@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
	
}
